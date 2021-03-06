<%--

    TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
    Copyright (C) 2007 Autentia Real Bussiness Solution S.L.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

--%>

<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/inc/tlibs.jsp" %>

<html>
  <head>
    <%@include file="/inc/uiCore.jsp" %>
  </head>	
  <body>
    
    <!-- editCompanyState.jsp: generated by stajanov code generator -->
    <f:loadBundle basename="com.autentia.tnt.resources.messages" var="msg" />
    <i:location place="editCompanyState" msg="${msg}"/> 
    
    <f:view>
        <%@include file="/inc/header.jsp" %>
      <h:form id="companyState" enctype="multipart/form-data">
        
        <%-- Header --%>
        <i:titleBar name="${companyStateBean.creationDate}" msg="${msg}">
          <h:commandLink action="#{companyStateBean.save}">
            <h:graphicImage value="/img/save.gif" styleClass="titleImg" />
          </h:commandLink>
          <h:commandLink action="#{companyStateBean.delete}" onclick="if( !confirm('#{msg['question.confirmDelete']}') ) return false;">
            <h:graphicImage value="/img/delete.gif" styleClass="titleImg" />
          </h:commandLink>
          <h:commandLink action="#{companyStateBean.list}" immediate="true">
            <h:graphicImage value="/img/back.gif" styleClass="titleImg" />
          </h:commandLink>
        </i:titleBar>
        
        <%-- Edition form --%>
        <table class="editTable" cellpadding="0" cellspacing="0">

<%-- companyState - generated by stajanov (do not edit/delete) --%>








                  
  
      <%-- Ignored field: id --%>
  
                                  
    
      <%-- Field: creationDate --%>
    <tr>
    	    		<td class="editLabelRW">*${msg['companyState.creationDate']}:</td>
    	      
      <td class="editFieldCell">

                  <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="creationDate" />
            <t:inputCalendar id="creationDate" value="#{companyStateBean.creationDate}"  required="true" styleClass="requiredFieldClass"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             />
          </h:panelGroup>

              </td>
    </tr>
                                  
    
      <%-- Field: description --%>
    <tr>
    	    		<td class="editLabelRW">*${msg['companyState.description']}:</td>
    	      
      <td class="editFieldCell">

                  <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="description" />
            <h:inputTextarea id="description" value="#{companyStateBean.description}" rows="20" cols="68" required="true" styleClass="requiredFieldClass"/>
          </h:panelGroup>

              </td>
    </tr>
                                  
  
      <%-- Ignored field: departmentId --%>
  
                                  
  
      <%-- Ignored field: insertDate --%>
  
                                  
  
      <%-- Ignored field: updateDate --%>
  
                                              
    
      <%-- Ignored field: user --%>
  
                                      


<%-- companyState - generated by stajanov (do not edit/delete) --%>

        </table>
        
      </h:form>
    </f:view>
    
  </body>
</html>  		

