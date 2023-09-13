<%@ include file="common/header.jspf" %>
<%@ include file="common/navigaton.jspf" %>

    <div class="container">

        <div class="row">

            <div class="col-md-12">

                <form:form class="form-group" method="POST" modelAttribute="task">
                    <div class="form-control">
                        <form:input type="hidden" path="id" />
                    <fieldset class="mb-3">
                        <form:label path="title">Title</form:label>
                        <form:input type="text" path="title"/>
                        <form:errors path="title" cssClass="text-danger" />
                    </fieldset>
                    <fieldset class="mb-3">
                        <form:label path="description">Description</form:label>
                        <form:input type="text" path="description"/>
                        <form:errors path="description" cssClass="text-danger" />
                    </fieldset>
                    <fieldset class="mb-3">
                        <form:label path="targetDate">Target date</form:label>
                        <form:input type="text" path="targetDate"/>
                        <form:errors path="targetDate" cssClass="text-danger" />
                    </fieldset>
                        <form:input type="hidden" path="done" />
                        <form:input type="hidden" path="createdDate" />

                    <input class="mt-2 btn btn-primary" type="submit" />
                    </div>
                </form:form>

            </div>
        </div>

    <div>

<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
    });
</script>