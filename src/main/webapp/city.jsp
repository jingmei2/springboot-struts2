<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Information</title>
    <style>
        body{
            font-family: verdana;
        }

        table {
            width: 500px;

        }

        table, th, td {
            border: 1px solid black;
            padding: 2px;
        }

        th{
            background-color: #00439A;
            color : #FFFFFF;
        }

        tr.odd{
            background-color: #CFCFCF;
        }

        tr.even{
            background-color: #1076F5;
        }
    </style>
</head>
<body>
<h1>User Information</h1>
<table>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>state</th>
        <th>country</th>
    </tr>
    <s:iterator value="cities" var="city" status="st" >
        <tr class="<s:if test="#st.id%2==0">even</s:if><s:else>odd</s:else>">
            <td align="center" id="id"><s:property value="#city.id"/></td>
            <td><s:property value="#city.name"/></td>
            <td><s:property value="#city"/></td>
            <td align="center">${city}</td>
        </tr>
    </s:iterator>

    <br/>======iterator String array======<br/>
    <s:iterator value="arryStr" var="array">
        <s:property value="array"/><br/>
    </s:iterator>
    <div></div>
</table>
</body>
<script>
    var cities = ${cities};
    console.info(cities);
    <%--console.info(<%=request.getContextPath()%>);--%>
    <%--console.info(<%=request.getRealPath("/")%>);--%>
</script>
</html>