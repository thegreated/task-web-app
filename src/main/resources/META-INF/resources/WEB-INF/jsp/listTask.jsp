<%@ include file="common/header.jspf" %>
<%@ include file="common/navigaton.jspf" %>

<div class="container">
    <div>
        Welcome ${name} to accenture
    </div>
    <hr>
    <h2> Your Task</h2>
    <table class="table">
        <thead>

        <th>Title</th>
        <th>Description</th>
        <th>Target date</th>
        <th>Created date</th>
        <th>Is Done?</th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach items="${task}" var="task">
            <tr>
                <td>${task.title}</td>
                <td>${task.description}</td>
                <td>${task.targetDate}</td>
                <td>${task.createdDate}</td>
                <td>${task.done}</td>
                <td><a class="btn btn-success" href="update-task?id=${task.id}">Update</a>
                    <a class="btn btn-danger" href="delete-task?id=${task.id}">Delete</a></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-primary" href="add-task">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>