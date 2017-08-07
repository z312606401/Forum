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
					<strong class="fl w">需要登录</strong> &nbsp;&nbsp;
					<span style="color: red; font-weight: bold; ">
						${message}
					</span>
				</th>
			</tr>
		</table>
	</div>

	<form:form action="person_login.do" commandName="person" method="post">
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%" 
				style="table-layout:fixed;border-top:0">
				<tr class="tr3">
					<td style="width: 120px; ">
						帐号:
					</td>
					<td>
						<form:input id="account" path="account"/>
					</td>
				</tr>

				<tr class="tr3">
					<td style="width: 120px; ">
						密码:
					</td>
					<td>
						<form:password  id="password" path="password"/>
					</td>
				</tr>

				<tr class="tr3">
					<td colspan="2">
						<input id="submit" type="submit" value="登陆">
					</td>
				</tr>
			</table>
		</div>
	</form:form>
</div>
<jsp:include flush="true" page="../footer.jsp" />