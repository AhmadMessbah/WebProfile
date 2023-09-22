<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <jsp:include page="css-import.jsp"></jsp:include>
</head>
<body>
<h1>Test</h1>

<form action="/rest/group" method="post">
    <input type="title" name="title">
    <input type="submit">
</form>

<div id="dataTable"></div>
<button onclick="showDataOnTable('dataTable', '/rest/group')">fetch</button>

<script>
    async function showDataOnTable(tableDiv, url) {
        const response = await fetch(url);
        const data = await response.json();

        const table = document.createElement("table");
        const tHead = table.createTHead();
        tHead.className = "tHead";
        const headRow = tHead.insertRow();
        headRow.className = "row";

        const keys = Object.keys(data[0]);
        keys.forEach(function (header) {
            const hCell = headRow.insertCell();
            hCell.innerHTML = header;
            hCell.style.border = "1px solid black";
            hCell.style.borderCollapse = "collapse";
            hCell.className ="col " + header + "Col";
        })

        const hCell = headRow.insertCell();
        hCell.innerHTML = "Operation";
        hCell.style.border = "1px solid black";
        hCell.style.borderCollapse = "collapse";
        hCell.className = "col operationCol";

        const tBody = table.createTBody();
        tBody.className = "tBody";

        data.forEach(function (item) {
            const bodyRow = tBody.insertRow();
            bodyRow.className = "row";

            keys.forEach(function (header) {
                const dCell = bodyRow.insertCell();
                dCell.className = "col " + header + "Col";
                dCell.innerHTML = item[header];
                dCell.style.border = "1px solid black";
                dCell.style.borderCollapse = "collapse";
            })

            const editBtn = document.createElement("button");
            editBtn.className = "btn btn-primary";
            editBtn.innerHTML = "<span><i class='fa fa-edit'></i>Edit</span>";

            const removeBtn = document.createElement("button");
            removeBtn.className = "btn btn-primary";
            removeBtn.innerHTML = "<span><i class='fa fa-remove'></i>Remove</span>";

            const dCell = bodyRow.insertCell();
            dCell.className = "col operationCol";
            dCell.style.border = "1px solid black";
            dCell.style.borderCollapse = "collapse";
            dCell.appendChild(editBtn);
            dCell.appendChild(removeBtn);
        });
        table.appendChild(tHead);
        table.appendChild(tBody);

        const dataTableDiv = document.getElementById(tableDiv);

        table.style.border = "1px solid black";
        table.style.borderCollapse = "collapse";

        dataTableDiv.appendChild(table);
    }

</script>
<jsp:include page="js-import.jsp"></jsp:include>

</body>
</html>
