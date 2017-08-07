<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include flush="true" page="../header.jsp"></jsp:include>


<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<input type="hidden" id="id" value="${ id }">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w">添加版面</strong> &nbsp;
					<span style="color: red; font-weight: bold; ">${message }</span>
				</th>
			</tr>
		</table>
	</div>


	<form:form action="board_add.do" commandName="board" method="post">
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%" style="table-layout:fixed;border-top:0" >
				<tr class="tr3">
					<td style="width: 120px; ">
						类别:
					</td>
					<td>
						<form:select path="categoryId" id="categoryId" >
							<c:forEach items="${ categoryList }" var="category">
								<form:option value="${ category.id }" label="${ category.name} "></form:option>
							</c:forEach>
						</form:select>
					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px; ">
						名称:
					</td>
					<td>
						<form:input id="name" path="name" />
					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px; ">
						描述:
					</td>
					<td>
						<form:textarea id="description" path="description"/>
					</td>
				</tr>

				<tr class="tr3">
					<td colspan="2">
						<input id="submit" type="submit" value="添加">
					</td>
				</tr>

			</table>
		</div>
	</form:form>
</div>

<jsp:include flush="true" page="../footer.jsp" />
