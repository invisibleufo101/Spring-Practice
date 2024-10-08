<%--
  Created by IntelliJ IDEA.
  User: tonyha
  Date: 2024-10-07
  Time: 4:20 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
        <i class="fas fa-download fa-sm text-white-50"></i>
        Generate Report
    </a>
</div>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Board List</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Board NO.</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Registered</th>
                    <th>Update</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="board" items="${boards}">
                <tr>
                    <td><c:out value="${ board.bno }" /></td>
                    <td><c:out value="${ board.title }" /></td>
                    <td><c:out value="${ board.writer }" /></td>
                    <td><c:out value="${ board.regDate }" /></td>
                    <td><c:out value="${ board.updateDate }" /></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


    <!-- Content Row -->
    <div class="row">

    </div>

<%@include file="../includes/footer.jsp"%>
<script>
    console.log("Hello World!");
</script>
<%@include file="../includes/end.jsp"%>


