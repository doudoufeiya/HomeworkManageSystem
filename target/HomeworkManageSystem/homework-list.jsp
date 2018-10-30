<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作业信息</title>
		<link rel="stylesheet" href="res/css/amazeui.min.css" />
		<link rel="stylesheet" href="res/css/admin.css" />
</head>
<body>
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">学生作业</strong><small></small></div>
			</div>

			<hr>

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-3">

				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-input-group am-input-group-sm">
						<input type="text" class="am-form-field" placeholder="请输入学生名">
						<span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
					</div>
				</div>
			</div>
			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr>
									<th class="table-check"><input type="checkbox"></th>
									<th class="table-id">ID</th>
									<th class="table-title">作业名称</th>
									<th class="table-type">学生学号</th>
									<th class="table-author am-hide-sm-only">文件名</th>
									<th class="table-date am-hide-sm-only">上传时间</th>
									<th>分数</th>
									<th class="table-set">操作</th>
								</tr>
							</thead>
							<tbody>
							    <c:forEach items="${homeworks}" var="h">
								<tr>
								    <td><input type="checkbox" value="1" name=""></td>
									<td>${h.sw_id}</td>
									<td>${h.sw_name}</td>
									<td>${h.sw_sid}</td>
									<td>${h.sw_file_name}</td>
									<td>${h.sw_correctTime}</td>
									<td class="am-hide-sm-only">${h.sw_grade}</td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span>评分</button>
												<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="redirect://filedown.action"><span class="am-icon-trash-o"></span> 下载  </button>
											</div>
										</div>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="am-cf">
							共 15 条记录
							<div class="am-fr">
								<ul class="am-pagination">
									<li class="am-disabled">
										<a href="#">«</a>
									</li>
									<li class="am-active">
										<a href="#">1</a>
									</li>
									<li>
										<a href="#">2</a>
									</li>
									<li>
										<a href="#">3</a>
									</li>
									<li>
										<a href="#">4</a>
									</li>
									<li>
										<a href="#">5</a>
									</li>
									<li>
										<a href="#">»</a>
									</li>
								</ul>
							</div>
						</div>
						<hr>
					</form>
				</div>
			</div>
		</div>
</body>
</html>