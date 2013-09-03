/**
 * @file GraphEntryPoint.java
 * 
 * @brief 
 * A demo for the Graph GWT wrapper.
 *
 * @license
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright © 2010-2011 Almende B.V.
 *
 * @author 	Jos de Jong, <jos@almende.org>
 * @date	  2011-02-02
 */


package com.chap.links.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.events.RangeChangeHandler;

import com.chap.links.client.Graph;

/**
 * GraphEntryPoint
 * 
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * The class GraphEntryPoint is for test purposes. To run the program,
 * you have to open the file Graph.gwt.xml, and uncomment the line 
 *     <entry-point class='com.chap.links.client.GraphEntryPoint'/>
 * such that the entry point is defined. 
 * 
 * If you want to create a stand-alone module for the graph, you have to 
 * comment the line with the entry point again, and then create a jar containing
 * only Graph.java, Graph.gwt.xml, graph.js, and graph.css
 */
public class GraphEntryPoint implements EntryPoint {
  final TextBox txtStartDate = new TextBox();
  final TextBox txtEndDate = new TextBox();
  final Button btnSetRange = new Button("Set");

  Graph graph = null;

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    // Create a callback to be called when the visualization API
    // has been loaded.
    Runnable onLoadCallback = new Runnable() {
      public void run() {
        RootPanel.get("txtStartDate").add(txtStartDate);
        RootPanel.get("txtEndDate").add(txtEndDate);
        RootPanel.get("btnSetRange").add(btnSetRange);
        
        Button btnAutoRange = new Button("Auto Range");
        btnAutoRange.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				graph.setValueRangeAuto();
				graph.setVisibleChartRangeAuto();
			}
        });
        RootPanel.get("btnAutoRange").add(btnAutoRange);
        
        // Add a handler to the add button
        btnSetRange.addClickHandler(new ClickHandler() {
          public void onClick(ClickEvent event) {
            setRange();
          }
        });

        // Create and populate a data table.
        DataTable data = DataTable.create();
        data.addColumn(DataTable.ColumnType.DATETIME, "time");
        data.addColumn(DataTable.ColumnType.NUMBER, "Function A");
        data.addColumn(DataTable.ColumnType.NUMBER, "Function B");

        DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

        // create data 
        Date d = dtf.parse("2010-08-23");
        int n = 1000; // number of datapoints
        for (int i = 0; i < n; i++) {
          data.addRow();
          data.setValue(i, 0, new Date(d.getTime()));
          data.setValue(i, 1, customFunction(i) / 100);
          data.setValue(i, 2, customFunction2(i) / 100);
          d.setTime(d.getTime() + 1000 * 60); // steps of one minute
        }
        
        Graph.Options options = Graph.Options.create();
        options.setHeight("400px");
        options.setLegendCheckboxes(true);
        //options.setVerticalStep(10);
        //options.setScale(Graph.Options.SCALE.HOUR, 2);
        options.setLineStyle(Graph.Options.LINESTYLE.DOT, 0);
        options.setLineRadius(1.0, 0);
        options.setLineColor("#FFA500", 0);
        options.setLineVisibe(false, 1);
        options.setLineColor("#FF0000", 1);
        options.setLineStyle(Graph.Options.LINESTYLE.DOTLINE);
        options.setVerticalMin(-1);
        options.setVerticalMax(1);
        options.setMin(dtf.parse("2010-08-22"));
        options.setMax(dtf.parse("2010-08-24"));
        options.setZoomMin(1000L * 60L * 60L);
        
/*
        String json =       
        	"[{ " + 
        	"	  \"label\" : \"Dataset A\", " + 
        	"	  \"data\" : [" + 
        	"    {\"date\": 1281823200000, \"value\" : 12.5}," + 
        	"	    {\"date\": 1281909600000, \"value\" : 3.5}" + 
        	"	  ]" + 
        	"	}," + 
        	"	{" + 
        	"	  \"label\" : \"Dataset B\"," +  
        	"	  \"data\" : [" + 
        	"	    {\"date\": 1281823200000, \"value\" : 3.2}," + 
        	"	    {\"date\": 1281996000000, \"value\" : 6.1}" + 
        	"	  ]" + 
        	"	}]";
        JavaScriptObject jsonData = JsonUtils.safeEval(json);
        */

        // create the linechart, with data and options
        graph = new Graph(data, options);
        
        //graph.draw(jso, options);
        
        // add event handlers
        graph.addRangeChangeHandler(createRangeChangeHandler(graph));
        
        RootPanel.get("mygraph").add(graph);

        getRange();
        
      }
    };

    // Load the visualization api, passing the onLoadCallback to be called
    // when loading is done.
    VisualizationUtils.loadVisualizationApi(onLoadCallback);    
  }

  double customFunction(double x) {
    return Math.sin(x/100) * Math.cos(x/50) * 50 + Math.sin(x/1000) * 50;
  }

  double customFunction2(double x) {
	    return Math.sin(x/100) * 25;
	  }
  
  /**
   * Get the range from the timeline and put it in the textboxes on screen
   */
  private void getRange() {
	  Graph.DateRange range = graph.getVisibleChartRange();
    DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");

    // set the new startdate and enddate
    txtStartDate.setText(dtf.format(range.getStart()));
    txtEndDate.setText(dtf.format(range.getEnd()));
  }
  
  /**
   * Get the entered dates from the textboxes on screen, and apply them to
   * the timeline
   */  
  private void setRange() {
    DateTimeFormat datetime = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");
    DateTimeFormat date = DateTimeFormat.getFormat("yyyy-MM-dd");
    
    Date startDate;
    Date endDate;
    
    // Try to parse the startdate
    try {
      startDate = datetime.parse(txtStartDate.getText());
    } catch (IllegalArgumentException err) {
      try {
      startDate = date.parse(txtStartDate.getText());
      } catch (IllegalArgumentException err2) {
        Window.alert("I don't understand the startdate that you entered :(");
        return;
      }
    }

    // Try to parse the enddate
    try {
      endDate = datetime.parse(txtEndDate.getText());
    } catch (IllegalArgumentException err) {
      try {
        endDate = date.parse(txtEndDate.getText());
      } catch (IllegalArgumentException err2) {
        Window.alert("I cannot make sense of the enddate that you entered :(");
        return;
      }
    }
    
    graph.setVisibleChartRange(startDate, endDate);
    graph.redraw();
  }
  
  /**
   * create a RangeChange handler (this event occurs when the user changes the 
   * visible range by moving or scrolling the graph).
   * @param Graph
   * @return
   */
  private RangeChangeHandler createRangeChangeHandler(final Graph graph) {
    return new RangeChangeHandler() {
      @Override
      public void onRangeChange(RangeChangeEvent event) {
        getRange();      
      }
    };
  }
}