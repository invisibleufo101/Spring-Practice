<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Read</h1>
<p class="mb-4">
    DataTables is a third party plugin that is used to generate the demo table below.
    For more information about DataTables, please visit the
    <a target="_blank" href="#">official DataTables documentation</a>.
</p>

<!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
            </div>
            <div class="card-body">
        <!-- bno -->
        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text">Bno</span>
            </div>
            <input type="text" name="bno" class="form-control" value="<c:out value="${board.bno}"/>" readonly>
        </div>
        <!-- //bno -->

        <!-- title -->
        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text">Title</span>
            </div>
            <input type="text" name="title" class="form-control" value="<c:out value="${board.title}"/>" readonly>
        </div>
        <!-- //title -->

        <!-- content -->
        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text">Content</span>
            </div>
            <input type="text" name="content" class="form-control" value="<c:out value="${board.content}"/>" readonly>
        </div>
        <!-- //content -->

        <!-- writer -->
        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text">Writer</span>
            </div>
            <input type="text" name="writer" class="form-control" value="<c:out value="${board.writer}"/>" readonly>
        </div>
        <!-- //writer -->

        <!-- regDate -->
        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text">Registered at</span>
            </div>
            <input type="text" class="form-control" value="<c:out value="${board.regDate}"/>" readonly>
        </div>
        <!-- //regDate -->

        <!-- buttons -->
        <div class="input-group input-group-lg">
            <button type="button" class="btn btn-primary btn-list">목륵으로</button>
            <button type="button" class="btn btn-warning btn-modify">글 수정</button>
        </div>
        <!-- //buttons -->

    </div>
</div>


<%@include file="../includes/footer.jsp"%>
<script>
    document.querySelector(".btn-list").addEventListener("click", (e) => {
        window.location = "/board/list";
    }, false);


    document.querySelector(".btn-modify").addEventListener("click", (e) => {
        window.location = "/board/modify/${bno}";
    }, false);

</script>
<%@include file="../includes/end.jsp"%>