<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dmitro
  Date: 30.05.2017
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>OwlMusic</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myfriends.css">

    <style>
        .card {
            display: flex;
            padding: 1%;
            margin-left: 5%;
            background: #ffffff;
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
            transition: 0.3s;
            width: 60%;
            height: 20%;
            border-radius: 5px;
            margin-bottom: 2%;
        }

        .card:hover {
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        }

        img {
            border-radius: 5px 5px 0 0;
        }

        .container {
            padding: 2px 16px;
        }
    </style>
</head>
<body>
<div id="pagewrap">
    <!--<ХЕДЕР=================================================================================================>-->
    <header id="header">
        <hgroup class="logoname">
            <img src="${contextPath}/resources/img/logoowl.png">
            <h1><a href="#">SpaceOwl Music</a></h1>
        </hgroup>
        <nav>
            <ul id="top-nav">
                <li><a href="#"><img src="${contextPath}/resources/img/13.png">Top Music</a></li>
                <li><a href="#"><img src="${contextPath}/resources/img/team.png">People</a></li>
                <li><a href="#"><img src="${contextPath}/resources/img/user.png"> Profile</a></li>
                <li>
                    <form id="searchform">
                        <input class="inputtext" type="search" placeholder="Search">
                        <input type="submit" value="Search">
                    </form>
                </li>
            </ul>
        </nav>
    </header>


    <div id="content">

            <c:forEach items="${users}" var="map">
                <div class="card">
                    <img src="data:${map.profile.avatar.mapperImage.contenttype};base64,${map.profile.avatar.mapperImage.base64}" alt="Avatar" style="width:100px; height: 100px">
                    <div class="container">
                        <h4><a href="${contextPath}/profile/${map.username}"><b >${map.firstName} ${map.lastName}</b></a></h4>
                        <p>Architect & Engineer</p>
                        <form >
                            <input type="submit" value="add in friend">
                        </form>
                    </div>
                </div>
            </c:forEach>

    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/mymusic.js"></script>
</body>
</html>