<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include flush="true" page="../header.jsp"></jsp:include>

<div id="main">
	<div class="t3" style="margin:8px auto">
		<table width="100%" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td>
					<strong class="fl w">
						<img src="/Forum_SSM/images/index/home_menu.gif" align="absmiddle"
							id="td_cate" onMouseOver="read.open('menu_cate','td_cate');"
							style="cursor:pointer;" />
						<a href="<c:url value="category_list.do" />?id=${ board.category.id }">${board.category.name }</a> &raquo; 
						<a href="<c:url value="board_list.do" />?id=${ board.id }">${ board.name }</a> 
					</strong>
					<div class="fr w">
						<a href="<c:url value="board_initSetAdmin.do" />?id=${ board.id }&action=initAdd">版主</a>:
						&nbsp;
						<c:forEach items="${ board.administrators }" var="person">
							<a href="<c:url value="person_view.do" />?id=${ person.id }">${person.account }</a>
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
	</div>

	<div class="c"></div>

	<div class="t z" style="margin:3px auto">
		<table cellspacing="0" cellpadding="0" width="100%" id="ajaxtable">
			<tr>
				<th class="h" colspan="6">
					<a href="<c:url value="board_list.do" />?id=${ board.id }">${board.name }</a>
				</th>
			</tr>
			<tbody style="table-layout:fixed;">
				<tr></tr>
				<tr class="tr2">
					<td class="tac y-style">状态</td>
					<td style="width:50%" class="tac">文章</td>
					<td style="width:17%" class="y-style">作者</td>
					<td style="width:6%" class="y-style">回复</td>
					<td style="width:6%" class="y-style">人气</td>
					<td style="width:17%" class="y-style">最后回复</td>
				</tr>

				<c:forEach var="thread" items="${ threadList }">
					<tr align="center" class="tr3 t_one">
						<td>
							<a title="打开新窗口" href="<c:url value="thread_list.do" />?id=${ thread.id }"target="_blank">
								<img src="/Forum_SSM/images/thread/topichot.gif" border=0> </a>
						</td>
						<td style="text-align:left;padding-left:8px" id="td_579742">
							<h3>
								<a href="<c:url value="thread_list.do" />?id=${ thread.id }">${thread.title }</a>
							</h3>
						</td>
						<td class="tal y-style">
							<a href="<c:url value="person_view.do" />?id=${ thread.author.id }" class="bl">${ thread.author.account }</a>
							<div class="f10">
								${ thread.datecreated }
							</div>
						</td>
						<td class="tal f10 y-style">
							${ thread.replycount }
						</td>
						<td class="tal f10 y-style">
							${ thread.hit }
						</td>
						<td class="tal y-style">
							&nbsp;
							<c:if test="${ thread.authorLastReplied != null }">
								<a href="<c:url value="person_view.do" />?id=${ thread.authorLastReplied.id }"
									class="bl">${ thread.authorLastReplied.account }</a>
								<div class="f10">
									${ thread.datelastreplied }
								</div>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" class="f_one" style="height:8px"></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="t3">
		<table width="100%" align="center" cellspacing="0" cellpadding="0">
			<tr>
				<td align="left" valign="middle">
					<div class="fl">
						<div class="pages">
							${ pagination }
						</div>
					</div>
				</td>
				<td style="text-align:right">
					<a href="<c:url value="/thread_initAdd.do" />?action=initAdd&id=${ board.id }">
						<img src="/Forum_SSM/images/post.png" id="td_post" /> </a>
				</td>
			</tr>
		</table>
	</div>

</div>


<jsp:include flush="true" page="../footer.jsp" />
