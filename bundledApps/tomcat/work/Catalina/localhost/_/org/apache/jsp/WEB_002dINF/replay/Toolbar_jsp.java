/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2013-03-11 20:57:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.replay;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.text.ParseException;
import org.archive.wayback.ResultURIConverter;
import org.archive.wayback.WaybackConstants;
import org.archive.wayback.core.CaptureSearchResult;
import org.archive.wayback.core.CaptureSearchResults;
import org.archive.wayback.core.UIResults;
import org.archive.wayback.core.WaybackRequest;
import org.archive.wayback.partition.CaptureSearchResultPartitionMap;
import org.archive.wayback.partition.PartitionPartitionMap;
import org.archive.wayback.partition.PartitionsToGraph;
import org.archive.wayback.partition.ToolBarData;
import org.archive.wayback.util.graph.Graph;
import org.archive.wayback.util.graph.GraphEncoder;
import org.archive.wayback.util.graph.GraphRenderer;
import org.archive.wayback.util.partition.Partition;
import org.archive.wayback.util.partition.Partitioner;
import org.archive.wayback.util.partition.PartitionSize;
import org.archive.wayback.util.StringFormatter;
import org.archive.wayback.util.url.UrlOperations;

public final class Toolbar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


UIResults results = UIResults.extractReplay(request);
WaybackRequest wbRequest = results.getWbRequest();
ResultURIConverter uriConverter = results.getURIConverter();
StringFormatter fmt = wbRequest.getFormatter();

String staticPrefix = results.getStaticPrefix();
String queryPrefix = results.getQueryPrefix();
String replayPrefix = results.getReplayPrefix();

String graphJspPrefix = results.getContextConfig("graphJspPrefix");
if(graphJspPrefix == null) {
	graphJspPrefix = queryPrefix;
}
ToolBarData data = new ToolBarData(results);

String searchUrl = 
	UrlOperations.stripDefaultPortFromUrl(wbRequest.getRequestUrl());
String searchUrlSafe = fmt.escapeHtml(searchUrl);
String searchUrlJS = fmt.escapeJavaScript(searchUrl);
Date firstYearDate = data.yearPartitions.get(0).getStart();
Date lastYearDate = data.yearPartitions.get(data.yearPartitions.size()-1).getEnd();

int resultIndex = 1;
int imgWidth = 375;
int imgHeight = 27;
int monthWidth = 2;
int yearWidth = 25;
String yearFormatKey = "PartitionSize.dateHeader.yearGraphLabel";
String encodedGraph = data.computeGraphString(yearFormatKey,imgWidth,imgHeight);
String graphImgUrl = graphJspPrefix + "jsp/graph.jsp?graphdata=" + encodedGraph;
// TODO: this is archivalUrl specific:
String starLink = fmt.escapeHtml(queryPrefix + wbRequest.getReplayTimestamp() + 
		"*/" + searchUrl);
		System.out.println("foo"+results);

      out.write("\n");
      out.write("<!-- BEGIN WAYBACK TOOLBAR INSERT -->\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print( staticPrefix );
      out.write("js/disclaim-element.js\" ></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print( staticPrefix );
      out.write("js/graph-calc.js\" ></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print( staticPrefix );
      out.write("jflot/jquery.min.js\" ></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("var firstDate = ");
      out.print( firstYearDate.getTime() );
      out.write(";\n");
      out.write("var lastDate = ");
      out.print( lastYearDate.getTime() );
      out.write(";\n");
      out.write("var wbPrefix = \"");
      out.print( replayPrefix );
      out.write("\";\n");
      out.write("var wbCurrentUrl = \"");
      out.print( searchUrlJS );
      out.write("\";\n");
      out.write("\n");
      out.write("var curYear = -1;\n");
      out.write("var curMonth = -1;\n");
      out.write("var yearCount = 15;\n");
      out.write("var firstYear = 1996;\n");
      out.write("var imgWidth=");
      out.print( imgWidth );
      out.write(";\n");
      out.write("var yearImgWidth = ");
      out.print( yearWidth );
      out.write(";\n");
      out.write("var monthImgWidth = ");
      out.print( monthWidth );
      out.write(";\n");
      out.write("var trackerVal = \"none\";\n");
      out.write("var displayDay = \"");
      out.print( fmt.format("ToolBar.curDayText",data.curResult.getCaptureDate()) );
      out.write("\";\n");
      out.write("var displayMonth = \"");
      out.print( fmt.format("ToolBar.curMonthText",data.curResult.getCaptureDate()) );
      out.write("\";\n");
      out.write("var displayYear = \"");
      out.print( fmt.format("ToolBar.curYearText",data.curResult.getCaptureDate()) );
      out.write("\";\n");
      out.write("var prettyMonths = [\"Jan\",\"Feb\",\"Mar\",\"Apr\",\"May\",\"Jun\",\"Jul\",\"Aug\",\"Sep\",\"Oct\",\"Nov\",\"Dec\"];\n");
      out.write("\n");
      out.write("function showTrackers(val) {\n");
      out.write("\tif(val == trackerVal) {\n");
      out.write("\t\treturn;\n");
      out.write("\t}\n");
      out.write("\tif(val == \"inline\") {\n");
      out.write("\t\tdocument.getElementById(\"displayYearEl\").style.color = \"#ec008c\";\n");
      out.write("\t\tdocument.getElementById(\"displayMonthEl\").style.color = \"#ec008c\";\n");
      out.write("\t\tdocument.getElementById(\"displayDayEl\").style.color = \"#ec008c\";\t\t\n");
      out.write("\t} else {\n");
      out.write("\t\tdocument.getElementById(\"displayYearEl\").innerHTML = displayYear;\n");
      out.write("\t\tdocument.getElementById(\"displayYearEl\").style.color = \"#ff0\";\n");
      out.write("\t\tdocument.getElementById(\"displayMonthEl\").innerHTML = displayMonth;\n");
      out.write("\t\tdocument.getElementById(\"displayMonthEl\").style.color = \"#ff0\";\n");
      out.write("\t\tdocument.getElementById(\"displayDayEl\").innerHTML = displayDay;\n");
      out.write("\t\tdocument.getElementById(\"displayDayEl\").style.color = \"#ff0\";\n");
      out.write("\t}\n");
      out.write("   document.getElementById(\"wbMouseTrackYearImg\").style.display = val;\n");
      out.write("   document.getElementById(\"wbMouseTrackMonthImg\").style.display = val;\n");
      out.write("   trackerVal = val;\n");
      out.write("}\n");
      out.write("function getElementX2(obj) {\n");
      out.write("\tvar thing = jQuery(obj);\n");
      out.write("\tif((thing == undefined) \n");
      out.write("\t\t\t|| (typeof thing == \"undefined\") \n");
      out.write("\t\t\t|| (typeof thing.offset == \"undefined\")) {\n");
      out.write("\t\treturn getElementX(obj);\n");
      out.write("\t}\n");
      out.write("\treturn Math.round(thing.offset().left);\n");
      out.write("}\n");
      out.write("function trackMouseMove(event,element) {\n");
      out.write("\n");
      out.write("   var eventX = getEventX(event);\n");
      out.write("   var elementX = getElementX2(element);\n");
      out.write("   var xOff = eventX - elementX;\n");
      out.write("\tif(xOff < 0) {\n");
      out.write("\t\txOff = 0;\n");
      out.write("\t} else if(xOff > imgWidth) {\n");
      out.write("\t\txOff = imgWidth;\n");
      out.write("\t}\n");
      out.write("   var monthOff = xOff % yearImgWidth;\n");
      out.write("\n");
      out.write("   var year = Math.floor(xOff / yearImgWidth);\n");
      out.write("\tvar yearStart = year * yearImgWidth;\n");
      out.write("   var monthOfYear = Math.floor(monthOff / monthImgWidth);\n");
      out.write("   if(monthOfYear > 11) {\n");
      out.write("       monthOfYear = 11;\n");
      out.write("   }\n");
      out.write("   // 1 extra border pixel at the left edge of the year:\n");
      out.write("   var month = (year * 12) + monthOfYear;\n");
      out.write("   var day = 1;\n");
      out.write("\tif(monthOff % 2 == 1) {\n");
      out.write("\t\tday = 15;\n");
      out.write("\t}\n");
      out.write("\tvar dateString = \n");
      out.write("\t\tzeroPad(year + firstYear) + \n");
      out.write("\t\tzeroPad(monthOfYear+1,2) +\n");
      out.write("\t\tzeroPad(day,2) + \"000000\";\n");
      out.write("\n");
      out.write("\tvar monthString = prettyMonths[monthOfYear];\n");
      out.write("\tdocument.getElementById(\"displayYearEl\").innerHTML = year + 1996;\n");
      out.write("\tdocument.getElementById(\"displayMonthEl\").innerHTML = monthString;\n");
      out.write("\t// looks too jarring when it changes..\n");
      out.write("\t//document.getElementById(\"displayDayEl\").innerHTML = zeroPad(day,2);\n");
      out.write("\n");
      out.write("\tvar url = wbPrefix + dateString + '/' +  wbCurrentUrl;\n");
      out.write("\tdocument.getElementById('wm-graph-anchor').href = url;\n");
      out.write("\n");
      out.write("   //document.getElementById(\"wmtbURL\").value=\"evX(\"+eventX+\") elX(\"+elementX+\") xO(\"+xOff+\") y(\"+year+\") m(\"+month+\") monthOff(\"+monthOff+\") DS(\"+dateString+\") Moy(\"+monthOfYear+\") ms(\"+monthString+\")\";\n");
      out.write("   if(curYear != year) {\n");
      out.write("       var yrOff = year * yearImgWidth;\n");
      out.write("       document.getElementById(\"wbMouseTrackYearImg\").style.left = yrOff + \"px\";\n");
      out.write("       curYear = year;\n");
      out.write("   }\n");
      out.write("   if(curMonth != month) {\n");
      out.write("       var mtOff = year + (month * monthImgWidth) + 1;\n");
      out.write("       document.getElementById(\"wbMouseTrackMonthImg\").style.left = mtOff + \"px\";\n");
      out.write("       curMonth = month;\n");
      out.write("   }\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">body{margin-top:0!important;padding-top:0!important;min-width:800px!important;}#wm-ipp a:hover{text-decoration:underline!important;}</style>\n");
      out.write("<div id=\"wm-ipp\" style=\"display:none; position:relative;padding:0 5px;min-height:70px;min-width:800px; z-index:9000;\">\n");
      out.write("<div id=\"wm-ipp-inside\" style=\"position:fixed;padding:0!important;margin:0!important;width:97%;min-width:780px;border:5px solid #000;border-top:none;background-image:url(");
      out.print( staticPrefix );
      out.write("images/toolbar/wm_tb_bk_trns.png);text-align:center;-moz-box-shadow:1px 1px 3px #333;-webkit-box-shadow:1px 1px 3px #333;box-shadow:1px 1px 3px #333;font-size:11px!important;font-family:'Lucida Grande','Arial',sans-serif!important;\">\n");
      out.write("   <table style=\"border-collapse:collapse;margin:0;padding:0;width:100%;\"><tbody><tr>\n");
      out.write("   <td style=\"padding:10px;vertical-align:top;min-width:110px;\">\n");
      out.write("   <a href=\"");
      out.print( queryPrefix );
      out.write("\" title=\"Wayback Machine home page\" style=\"background-color:transparent;border:none;\"><img src=\"");
      out.print( staticPrefix );
      out.write("images/toolbar/wayback-toolbar-logo.png\" alt=\"Wayback Machine\" width=\"110\" height=\"39\" border=\"0\"/></a>\n");
      out.write("   </td>\n");
      out.write("   <td style=\"padding:0!important;text-align:center;vertical-align:top;width:100%;\">\n");
      out.write("\n");
      out.write("       <table style=\"border-collapse:collapse;margin:0 auto;padding:0;width:570px;\"><tbody><tr>\n");
      out.write("       <td style=\"padding:3px 0;\" colspan=\"2\">\n");
      out.write("       <form target=\"_top\" method=\"get\" action=\"");
      out.print( queryPrefix );
      out.write("query\" name=\"wmtb\" id=\"wmtb\" style=\"margin:0!important;padding:0!important;\"><input type=\"text\" name=\"");
      out.print( WaybackRequest.REQUEST_URL );
      out.write("\" id=\"wmtbURL\" value=\"");
      out.print( searchUrlSafe );
      out.write("\" style=\"width:400px;font-size:11px;font-family:'Lucida Grande','Arial',sans-serif;\"/><input type=\"hidden\" name=\"");
      out.print( WaybackRequest.REQUEST_TYPE );
      out.write("\" value=\"");
      out.print( WaybackRequest.REQUEST_REPLAY_QUERY );
      out.write("\"><input type=\"hidden\" name=\"");
      out.print( WaybackRequest.REQUEST_DATE );
      out.write("\" value=\"");
      out.print( data.curResult.getCaptureTimestamp() );
      out.write("\"><input type=\"submit\" value=\"Go\" style=\"font-size:11px;font-family:'Lucida Grande','Arial',sans-serif;margin-left:5px;\"/><span id=\"wm_tb_options\" style=\"display:block;\"></span></form>\n");
      out.write("       </td>\n");
      out.write("       <td style=\"vertical-align:bottom;padding:5px 0 0 0!important;\" rowspan=\"2\">\n");
      out.write("           <table style=\"border-collapse:collapse;width:110px;color:#99a;font-family:'Helvetica','Lucida Grande','Arial',sans-serif;\"><tbody>\n");
      out.write("\t\t\t\n");
      out.write("           <!-- NEXT/PREV MONTH NAV AND MONTH INDICATOR -->\n");
      out.write("           <tr style=\"width:110px;height:16px;font-size:10px!important;\">\n");
      out.write("           \t<td style=\"padding-right:9px;font-size:11px!important;font-weight:bold;text-transform:uppercase;text-align:right;white-space:nowrap;overflow:visible;\" nowrap=\"nowrap\">\n");
      out.write("               ");

               	if(data.monthPrevResult == null) {
                       
      out.write("\n");
      out.write("                       ");
      out.print( fmt.format("ToolBar.noPrevMonthText",ToolBarData.addMonth(data.curResult.getCaptureDate(),-1)) );
      out.write("\n");
      out.write("                       ");

               	} else {
		                
      out.write("\n");
      out.write("\t\t                <a href=\"");
      out.print( data.makeReplayURL(data.monthPrevResult) );
      out.write("\" style=\"text-decoration:none;color:#33f;font-weight:bold;background-color:transparent;border:none;\" title=\"");
      out.print( fmt.format("ToolBar.prevMonthTitle",data.monthPrevResult.getCaptureDate()) );
      out.write("\"><strong>");
      out.print( fmt.format("ToolBar.prevMonthText",data.monthPrevResult.getCaptureDate()).toUpperCase() );
      out.write("</strong></a>\n");
      out.write("\t\t                ");

               	}
               
      out.write("\n");
      out.write("               </td>\n");
      out.write("               <td id=\"displayMonthEl\" style=\"background:#000;color:#ff0;font-size:11px!important;font-weight:bold;text-transform:uppercase;width:34px;height:15px;padding-top:1px;text-align:center;\" title=\"");
      out.print( fmt.format("ToolBar.curMonthTitle",data.curResult.getCaptureDate()) );
      out.write('"');
      out.write('>');
      out.print( fmt.format("ToolBar.curMonthText",data.curResult.getCaptureDate()).toUpperCase() );
      out.write("</td>\n");
      out.write("\t\t\t\t<td style=\"padding-left:9px;font-size:11px!important;font-weight:bold;text-transform:uppercase;white-space:nowrap;overflow:visible;\" nowrap=\"nowrap\">\n");
      out.write("               ");

               	if(data.monthNextResult == null) {
                       
      out.write("\n");
      out.write("                       ");
      out.print( fmt.format("ToolBar.noNextMonthText",ToolBarData.addMonth(data.curResult.getCaptureDate(),1)) );
      out.write("\n");
      out.write("                       ");

               	} else {
		                
      out.write("\n");
      out.write("\t\t                <a href=\"");
      out.print( data.makeReplayURL(data.monthNextResult) );
      out.write("\" style=\"text-decoration:none;color:#33f;font-weight:bold;background-color:transparent;border:none;\" title=\"");
      out.print( fmt.format("ToolBar.nextMonthTitle",data.monthNextResult.getCaptureDate()) );
      out.write("\"><strong>");
      out.print( fmt.format("ToolBar.nextMonthText",data.monthNextResult.getCaptureDate()).toUpperCase() );
      out.write("</strong></a>\n");
      out.write("\t\t                ");

               	}
               
      out.write("\n");
      out.write("               </td>\n");
      out.write("           </tr>\n");
      out.write("\n");
      out.write("           <!-- NEXT/PREV CAPTURE NAV AND DAY OF MONTH INDICATOR -->\n");
      out.write("           <tr>\n");
      out.write("               <td style=\"padding-right:9px;white-space:nowrap;overflow:visible;text-align:right!important;vertical-align:middle!important;\" nowrap=\"nowrap\">\n");
      out.write("               ");

               	if(data.prevResult == null) {
                       
      out.write("\n");
      out.write("                       <img src=\"");
      out.print( staticPrefix );
      out.write("images/toolbar/wm_tb_prv_off.png\" alt=\"Previous capture\" width=\"14\" height=\"16\" border=\"0\" />\n");
      out.write("                       ");

               	} else {
		                
      out.write("\n");
      out.write("\t\t                <a href=\"");
      out.print( data.makeReplayURL(data.prevResult) );
      out.write("\" title=\"");
      out.print( fmt.format("ToolBar.prevTitle",data.prevResult.getCaptureDate()) );
      out.write("\" style=\"background-color:transparent;border:none;\"><img src=\"");
      out.print( staticPrefix );
      out.write("images/toolbar/wm_tb_prv_on.png\" alt=\"Previous capture\" width=\"14\" height=\"16\" border=\"0\" /></a>\n");
      out.write("\t\t                ");

               	}
               
      out.write("\n");
      out.write("               </td>\n");
      out.write("               <td id=\"displayDayEl\" style=\"background:#000;color:#ff0;width:34px;height:24px;padding:2px 0 0 0;text-align:center;font-size:24px;font-weight: bold;\" title=\"");
      out.print( fmt.format("ToolBar.curDayTitle",data.curResult.getCaptureDate()) );
      out.write('"');
      out.write('>');
      out.print( fmt.format("ToolBar.curDayText",data.curResult.getCaptureDate()) );
      out.write("</td>\n");
      out.write("\t\t\t\t<td style=\"padding-left:9px;white-space:nowrap;overflow:visible;text-align:left!important;vertical-align:middle!important;\" nowrap=\"nowrap\">\n");
      out.write("               ");

               	if(data.nextResult == null) {
                       
      out.write("\n");
      out.write("                       <img src=\"");
      out.print( staticPrefix );
      out.write("images/toolbar/wm_tb_nxt_off.png\" alt=\"Next capture\" width=\"14\" height=\"16\" border=\"0\"/>\n");
      out.write("                       ");

               	} else {
		                
      out.write("\n");
      out.write("\t\t                <a href=\"");
      out.print( data.makeReplayURL(data.nextResult) );
      out.write("\" title=\"");
      out.print( fmt.format("ToolBar.nextTitle",data.nextResult.getCaptureDate()) );
      out.write("\" style=\"background-color:transparent;border:none;\"><img src=\"");
      out.print( staticPrefix );
      out.write("images/toolbar/wm_tb_nxt_on.png\" alt=\"Next capture\" width=\"14\" height=\"16\" border=\"0\"/></a>\n");
      out.write("\t\t                ");

               	}
               
      out.write("\n");
      out.write("\t\t\t    </td>\n");
      out.write("           </tr>\n");
      out.write("\n");
      out.write("           <!-- NEXT/PREV YEAR NAV AND YEAR INDICATOR -->\n");
      out.write("           <tr style=\"width:110px;height:13px;font-size:9px!important;\">\n");
      out.write("\t\t\t\t<td style=\"padding-right:9px;font-size:11px!important;font-weight: bold;text-align:right;white-space:nowrap;overflow:visible;\" nowrap=\"nowrap\">\n");
      out.write("               ");

               	if(data.yearPrevResult == null) {
                       
      out.write("\n");
      out.write("                       ");
      out.print( fmt.format("ToolBar.noPrevYearText",ToolBarData.addYear(data.curResult.getCaptureDate(),-1)) );
      out.write("\n");
      out.write("                       ");

               	} else {
		                
      out.write("\n");
      out.write("\t\t                <a href=\"");
      out.print( data.makeReplayURL(data.yearPrevResult) );
      out.write("\" style=\"text-decoration:none;color:#33f;font-weight:bold;background-color:transparent;border:none;\" title=\"");
      out.print( fmt.format("ToolBar.prevYearTitle",data.yearPrevResult.getCaptureDate()) );
      out.write("\"><strong>");
      out.print( fmt.format("ToolBar.prevYearText",data.yearPrevResult.getCaptureDate()) );
      out.write("</strong></a>\n");
      out.write("\t\t                ");

               	}
               
      out.write("\n");
      out.write("               </td>\n");
      out.write("               <td id=\"displayYearEl\" style=\"background:#000;color:#ff0;font-size:11px!important;font-weight: bold;padding-top:1px;width:34px;height:13px;text-align:center;\" title=\"");
      out.print( fmt.format("ToolBar.curYearTitle",data.curResult.getCaptureDate()) );
      out.write('"');
      out.write('>');
      out.print( fmt.format("ToolBar.curYearText",data.curResult.getCaptureDate()) );
      out.write("</td>\n");
      out.write("\t\t\t\t<td style=\"padding-left:9px;font-size:11px!important;font-weight: bold;white-space:nowrap;overflow:visible;\" nowrap=\"nowrap\">\n");
      out.write("               ");

               	if(data.yearNextResult == null) {
                       
      out.write("\n");
      out.write("                       ");
      out.print( fmt.format("ToolBar.noNextYearText",ToolBarData.addYear(data.curResult.getCaptureDate(),1)) );
      out.write("\n");
      out.write("                       ");

               	} else {
		                
      out.write("\n");
      out.write("\t\t                <a href=\"");
      out.print( data.makeReplayURL(data.yearNextResult) );
      out.write("\" style=\"text-decoration:none;color:#33f;font-weight:bold;background-color:transparent;border:none;\" title=\"");
      out.print( fmt.format("ToolBar.nextYearTitle",data.yearNextResult.getCaptureDate()) );
      out.write("\"><strong>");
      out.print( fmt.format("ToolBar.nextYearText",data.yearNextResult.getCaptureDate()) );
      out.write("</strong></a>\n");
      out.write("\t\t                ");

               	}
               
      out.write("\n");
      out.write("\t\t\t\t</td>\n");
      out.write("           </tr>\n");
      out.write("           </tbody></table>\n");
      out.write("       </td>\n");
      out.write("\t\t<td style=\"padding-left: 1.0em;\">\n");
      out.write("\t\t\t<script type=\"text/javascript\">\n");
      out.write("\t\t\t\tfunction setCookie(){\n");
      out.write("\t\t\t\t\tcreateCookie(\"waybackUserAgent\",$(\"#userAgent\").find(\":selected\").attr(\"value\"),30);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\n");
      out.write("\t\t\t\tfunction setUserAgentDropdownBasedOnCookie(){\n");
      out.write("\t\t\t\t\tvar cookieValue = readCookie(\"waybackUserAgent\");\n");
      out.write("\t\t\t\t\tif(cookieValue){\n");
      out.write("\t\t\t\t\t\t$(\"#userAgent\").val(readCookie(\"waybackUserAgent\"));\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t/* From QuirksMode http://www.quirksmode.org/js/cookies.html */\n");
      out.write("\t\t\t\tfunction createCookie(name, value, days) {\n");
      out.write("\t\t\t\t\tif (days) {\n");
      out.write("\t\t\t\t\t\tvar date = new Date();\n");
      out.write("\t\t\t\t\t\tdate.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));\n");
      out.write("\t\t\t\t\t\tvar expires = \"; expires=\" + date.toGMTString();\n");
      out.write("\t\t\t\t\t} else var expires = \"\";\n");
      out.write("\t\t\t\t\tdocument.cookie = escape(name) + \"=\" + escape(value) + expires + \"; path=/\";\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tfunction readCookie(name) {\n");
      out.write("\t\t\t\t\tvar nameEQ = escape(name) + \"=\";\n");
      out.write("\t\t\t\t\tvar ca = document.cookie.split(';');\n");
      out.write("\t\t\t\t\tfor (var i = 0; i < ca.length; i++) {\n");
      out.write("\t\t\t\t\t\tvar c = ca[i];\n");
      out.write("\t\t\t\t\t\twhile (c.charAt(0) == ' ') c = c.substring(1, c.length);\n");
      out.write("\t\t\t\t\t\tif (c.indexOf(nameEQ) == 0) return unescape(c.substring(nameEQ.length, c.length));\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t\treturn null;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tfunction eraseCookie(name) {\n");
      out.write("\t\t\t\t\tcreateCookie(name, \"\", -1);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t$(document).ready(function(){\n");
      out.write("\t\t\t\t\tsetUserAgentDropdownBasedOnCookie();\n");
      out.write("\t\t\t\t\t$(\"#userAgent\").change(setCookie);\t\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t</script>\n");
      out.write("\t\t\t<label for=\"userAgent\">Filter By User Agent:</label><br />\n");
      out.write("\t\t\t<select id=\"userAgent\" style=\"marging-left: 5px;\">\n");
      out.write("\t\t\t\t<option value=\"all\">All User Agents</option>\n");
      out.write("\t\t\t\t<option disabled=\"disabled\"></option>\n");
      out.write("\t\t\t\t<option disabled=\"disabled\">Switch to Version</option>\n");
      out.write("\t\t\t\t<option value=\"mobile\"> &bull; Mobile Only</option>\n");
      out.write("\t\t\t\t<option value=\"desktop\"> &bull; Desktop Only</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</td>\n");
      out.write("       </tr>\n");
      out.write("       <tr>\n");
      out.write("       <td style=\"vertical-align:middle;padding:0!important;\">\n");
      out.write("           <a href=\"");
      out.print( starLink );
      out.write("\" style=\"color:#33f;font-size:11px;font-weight:bold;background-color:transparent;border:none;\" title=\"");
      out.print( fmt.format("ToolBar.numCapturesTitle") );
      out.write("\"><strong>");
      out.print( fmt.format("ToolBar.numCapturesText",data.getResultCount()) );
      out.write("</strong></a>\n");
      out.write("           <div style=\"margin:0!important;padding:0!important;color:#666;font-size:9px;padding-top:2px!important;white-space:nowrap;\" title=\"");
      out.print( fmt.format("ToolBar.captureRangeTitle") );
      out.write('"');
      out.write('>');
      out.print( fmt.format("ToolBar.captureRangeText",data.getFirstResultDate(),data.getLastResultDate()) );
      out.write("</div>\n");
      out.write("       </td>\n");
      out.write("       <td style=\"padding:0!important;\">\n");
      out.write("       <a style=\"position:relative; white-space:nowrap; width:");
      out.print( imgWidth );
      out.write("px;height:");
      out.print( imgHeight );
      out.write("px;\" href=\"\" id=\"wm-graph-anchor\">\n");
      out.write("       <div id=\"wm-ipp-sparkline\" style=\"position:relative; white-space:nowrap; width:");
      out.print( imgWidth );
      out.write("px;height:");
      out.print( imgHeight );
      out.write("px;background-color:#fff;cursor:pointer;border-right:1px solid #ccc;\" title=\"");
      out.print( fmt.format("ToolBar.sparklineTitle") );
      out.write("\">\n");
      out.write("\t\t\t<img id=\"sparklineImgId\" style=\"position:absolute; z-index:9012; top:0px; left:0px;\"\n");
      out.write("\t\t\t\tonmouseover=\"showTrackers('inline');\" \n");
      out.write("\t\t\t\tonmouseout=\"showTrackers('none');\"\n");
      out.write("\t\t\t\tonmousemove=\"trackMouseMove(event,this)\"\n");
      out.write("\t\t\t\talt=\"sparklines\"\n");
      out.write("\t\t\t\twidth=\"");
      out.print( imgWidth );
      out.write("\"\n");
      out.write("\t\t\t\theight=\"");
      out.print( imgHeight );
      out.write("\"\n");
      out.write("\t\t\t\tborder=\"0\"\n");
      out.write("\t\t\t\tsrc=\"");
      out.print( graphImgUrl );
      out.write("\"></img>\n");
      out.write("\t\t\t<img id=\"wbMouseTrackYearImg\" \n");
      out.write("\t\t\t\tstyle=\"display:none; position:absolute; z-index:9010;\"\n");
      out.write("\t\t\t\twidth=\"");
      out.print( yearWidth );
      out.write("\" \n");
      out.write("\t\t\t\theight=\"");
      out.print( imgHeight );
      out.write("\"\n");
      out.write("\t\t\t\tborder=\"0\"\n");
      out.write("\t\t\t\tsrc=\"");
      out.print( staticPrefix );
      out.write("images/toolbar/transp-yellow-pixel.png\"></img>\n");
      out.write("\t\t\t<img id=\"wbMouseTrackMonthImg\"\n");
      out.write("\t\t\t\tstyle=\"display:none; position:absolute; z-index:9011; \" \n");
      out.write("\t\t\t\twidth=\"");
      out.print( monthWidth );
      out.write("\"\n");
      out.write("\t\t\t\theight=\"");
      out.print( imgHeight );
      out.write("\" \n");
      out.write("\t\t\t\tborder=\"0\"\n");
      out.write("\t\t\t\tsrc=\"");
      out.print( staticPrefix );
      out.write("images/toolbar/transp-red-pixel.png\"></img>\n");
      out.write("       </div>\n");
      out.write("\t\t</a>\n");
      out.write("\n");
      out.write("       </td>\n");
      out.write("       </tr></tbody></table>\n");
      out.write("   </td>\n");
      out.write("   <td style=\"text-align:right;padding:5px;width:65px;font-size:11px!important;\">\n");
      out.write("       <a href=\"javascript:;\" onclick=\"document.getElementById('wm-ipp').style.display='none';\" style=\"display:block;padding-right:18px;background:url(");
      out.print( staticPrefix );
      out.write("images/toolbar/wm_tb_close.png) no-repeat 100% 0;color:#33f;font-family:'Lucida Grande','Arial',sans-serif;margin-bottom:23px;background-color:transparent;border:none;\" title=\"");
      out.print( fmt.format("ToolBar.closeTitle") );
      out.write('"');
      out.write('>');
      out.print( fmt.format("ToolBar.closeText") );
      out.write("</a>\n");
      out.write("       <a href=\"https://webarchive.jira.com/wiki/display/WWMOS/FAQs\" style=\"display:block;padding-right:18px;background:url(");
      out.print( staticPrefix );
      out.write("images/toolbar/wm_tb_help.png) no-repeat 100% 0;color:#33f;font-family:'Lucida Grande','Arial',sans-serif;background-color:transparent;border:none;\" title=\"");
      out.print( fmt.format("ToolBar.helpTitle") );
      out.write('"');
      out.write('>');
      out.print( fmt.format("ToolBar.helpText") );
      out.write("</a>\n");
      out.write("   </td>\n");
      out.write("   </tr></tbody></table>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write(" var wmDisclaimBanner = document.getElementById(\"wm-ipp\");\n");
      out.write(" if(wmDisclaimBanner != null) {\n");
      out.write("   disclaimElement(wmDisclaimBanner);\n");
      out.write(" }\n");
      out.write("</script>\n");
      out.write("<!-- END WAYBACK TOOLBAR INSERT -->\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
