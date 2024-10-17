<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Modify</h1>
<p class="mb-4">
    DataTables is a third party plugin that is used to generate the demo table below.
    For more information about DataTables, please visit the
    <a target="_blank" href="#">official DataTables documentation</a>.
</p>

<!-- Content -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
    </div>
    <div class="card-body">
        <form id="actionForm" action="/board/modify" method="post">
<%--            <!-- bno -->--%>
<%--            <div class="input-group input-group-lg">--%>
<%--                <div class="input-group-prepend">--%>
<%--                    <span class="input-group-text">Bno</span>--%>
<%--                </div>--%>
<%--                <input type="text" name="bno" class="form-control" value="<c:out value="${board.bno}"/>" readonly>--%>
<%--            </div>--%>
<%--            <!-- //bno -->--%>

            <input type="hidden" name="bno" class="form-control" value="<c:out value="${board.bno}"/>" readonly>

            <!-- title -->
            <div class="input-group input-group-lg">
                <div class="input-group-prepend">
                    <span class="input-group-text">Title</span>
                </div>
                <input type="text" name="title" class="form-control" value="<c:out value="${board.title}"/>">
            </div>
            <!-- //title -->

            <!-- writer -->
            <div class="input-group input-group-lg">
                <div class="input-group-prepend">
                    <span class="input-group-text">Writer</span>
                </div>
                <input type="text" name="writer" class="form-control" value="<c:out value="${board.writer}"/>" readonly>
            </div>
            <!-- //writer -->

            <!-- content -->
            <div class="input-group input-group-lg">
                <div class="input-group-prepend">
                    <span class="input-group-text">Content</span>
                </div>
                <input type="text" name="content" class="form-control" value="<c:out value="${board.content}"/>">
            </div>
            <!-- //content -->

            <!-- regDate -->
            <div class="input-group input-group-lg">
                <div class="input-group-prepend">
                    <span class="input-group-text">Registered at</span>
                </div>
                <input type="text" class="form-control" value="<c:out value="${board.regDate}"/>" readonly>
            </div>
            <!-- //regDate -->

            <div class="input-group input-group-lg mt-3">
                <button type="submit" id="list-btn" class="btn btn-primary btn-list">글 목록으로</button>
                <button type="submit" id="modify-btn" class="btn btn-warning btn-list">글 수정</button>
                <button type="submit" id="delete-btn" class="btn btn-danger btn-list">글 삭제</button>
            </div>
        </form>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>
<script>
    const bno = '${board.bno}';
    const actionForm = document.querySelector('#actionForm');
    document.querySelector('#list-btn').addEventListener('click', (e) => {
        e.preventDefault();e.stopPropagation();
        window.location = "/board/list";
    });

    document.querySelector('#modify-btn').addEventListener('click', (e) => {
        e.preventDefault();
        e.stopPropagation();

        actionForm.action = `/board/modify/\${bno}`;
        actionForm.method = 'post';
        actionForm.submit();
    });

    document.querySelector('#delete-btn').addEventListener('click', (e) => {
        e.preventDefault();
        e.stopPropagation();

        actionForm.action = `/board/delete/\${bno}`;
        actionForm.method = 'post';
        actionForm.submit();
    });

</script>
<%@include file="../includes/end.jsp"%>
