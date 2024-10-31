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
            <table class="table table-bordered" id="dataTable">
                <thead>
                <tr>
                    <th>Board NO.</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Registered</th>
                    <th>Update</th>
                </tr>
                </thead>
                <tbody class="tbody">
                <c:forEach var="board" items="${boards}">
                <tr data-bno="${board.bno}">
                    <td><c:out value="${ board.bno }" /></td>
                    <td><c:out value="${ board.title }" /></td>
                    <td><c:out value="${ board.writer }" /></td>
                    <td><c:out value="${ board.regDate }" /></td>
                    <td><c:out value="${ board.updateDate }" /></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
                <!-- Pagingnation -->
                <nav aria-label="pagination">
                    <ul class="pagination">
                        <c:if test="${pageMaker.prev}">
                        <li class="page-item">
                            <a id="jumpPrev" class="page-link"><<</a>
                        </li>
                        </c:if>
                        <c:forEach var="page" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                        <li class="page-item ${criteria.pageNum == page ? 'active' : ''}">
                            <a class="page-link" href="?pageNum=${page}">${page}</a>
                        </li>
                        </c:forEach>

                        <c:if test="${pageMaker.next}">
                        <li class="page-item">
                            <a id="jumpNext" class="page-link">>></a>
                        </li>
                        </c:if>
                    </ul>
                </nav>
                <!-- //Pagingnation -->
        </div>
    </div>


    <!-- Content Row -->
    <div class="row">

    </div>

    <!-- Modal -->
    <div class="modal fade" tabindex="-1" role="dialog" id="myModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">시스템 메세지</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>글이 정상적으로 등록되었습니다.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">확인</button>
                </div>
            </div>
        </div>
    </div>
    <!-- //Modal -->

<%@include file="../includes/footer.jsp"%>
<script>
    // result -> whether a new Post has been registered or not
    const result = '${result}';
    const myModal = new bootstrap.Modal(document.getElementById("myModal"));

    // if new Post has been registered, show Modal message
    if (result){
        myModal.show();
    }

    // When clicking on the table row...
    document.querySelector('.tbody').addEventListener('click', (e) => {
        const tableRow = e.target.closest('tr'); // select the row's closest parent el (in this case <tr>)
        const bno = tableRow.dataset.bno; // the row's PK
        window.location = `/board/read/\${bno}`; // direct the user to the corresponding Board post with that bno
    }, false);


    const pageNum = '${criteria.pageNum}';
    const jumpPrevBtn = document.querySelector('#jumpPrev');
    const jumpNextBtn = document.querySelector('#jumpNext');

    // jumpPrevBtn.addEventListener("click", (e) => {
    //
    // });
    //
    // jumpNextBtn.addEventListener("click", (e) => {
    //
    // });

</script>
<%@include file="../includes/end.jsp"%>


