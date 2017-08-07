<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include flush="true" page="../header.jsp"></jsp:include>

<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w"><b>添加类别</b></strong>
				</th>
			</tr>
		</table>
	</div>

	<form:form action="category_add.do" commandName="category" method="post">
		<input type="hidden" name="action" value="add">
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr1 r_one">
					<th style="width:20%" class="r_two"  style="text-align: right">
						名称
					</th>
					<th style="vertical-align:bottom;padding-left:15px;border:0">
						<form:input id="name" path="name"/>
						<br/><br/>
						<input id="submit" type="submit" value="提交">
					</th>
				</tr>
			</table>
		</div>
	</form:form>
</div>
<jsp:include flush="true" page="../footer.jsp" />
