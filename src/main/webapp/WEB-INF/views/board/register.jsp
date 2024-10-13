<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../includes/header.jsp"%>

<!-- Page Heading -->
<%--<h1 class="h3 mb-2 text-gray-800">Register</h1>--%>
<%--<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.--%>
<%--    For more information about DataTables, please visit the--%>
<%--    <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.--%>
<%--</p>--%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Register</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Board Register</div>
            <div class="panel-body">
                <form role="form" action="/board/register" method="post">

<%--                    Title--%>
                    <div class="form-group">
                        <label>Title</label>
                        <input type="text" class="form-control" name="title"/>
                    </div>

<%--                    Content--%>
                    <div class="form-group">
                        <label>Content</label>
                        <textarea name="content" id="" rows="3" class="form-control"></textarea>
                    </div>

<%--                    Writer--%>
                    <div class="form-group">
                        <label>Writer</label>
                        <input type="text" name="writer" class="form-control">
                    </div>

<%--                    Submit and Reset buttons--%>
                    <button type="submit" class="btn btn-priamry">입력</button>
                    <button type="reset" class="btn btn-secondary">취소</button>
                </form>
            </div>
        </div>
    </div>
</div>



<%@include file="../includes/footer.jsp" %>
<script>

</script>
<%@include file="../includes/end.jsp" %>