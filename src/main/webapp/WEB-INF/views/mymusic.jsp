<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: Dmitro
  Date: 28.05.2017
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>OwlMusic</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
    <!-- Generic page styles -->
    <link rel="stylesheet" href="${contextPath}/resources/css/mymusic.css">

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
        <div id="addtrack" class="col-sm-4">
            <section class="usermusic">
                <button data-music="playlist" class="createplaylist">
                    Add track
                </button>
            </section>
            <div class="popup" id="playlist">
                <div class="popup-inner">
                    <div class="popup-close">X</div>
                    <h2>Add track</h2>
                    <div class="conteineraddtrack">
                        <div id="headerforplaylist" class="row">
                            <div class="col-md-4">
                                <img id="baseimgtrack" src="${contextPath}/resources/img/owlchat.png">
                                <form id="formimgtrack">
                                    <input type="file" name="imgtrack" id="imgplaylist" class="inputfile" />
                                    <label for="imgtrack"> Choose a file</label>
                                    <button id="uploadimgplaylist" type="button">Upload</button>
                                </form>
                            </div>
                            <div  class="col-md-8">
                                <article>1.Enter the name of the track please </article>
                                <article>2.Choose the audiofile</article>
                                <form id="formtrackname">
                                    <input type="text" id="trackname" placeholder=" Enter trackname">
                                </form>
                                <form class="settingsprivasy">
                                    <article>Privasy settings</article>
                                    <label class="checkbox-inline"><input type="radio" name="privacyRadio" value="1" checked>Only I</label>
                                    <label class="checkbox-inline"><input type="radio" name="privacyRadio" value="2">Only My Friends</label>
                                    <label class="checkbox-inline"><input type="radio" name="privacyRadio" value="3">All people</label>
                                </form>
                                <form id="formtrackdescription">

                                </form>
                                <form id="formaddmusic">
                                    <input type="text" id="trackdescription" placeholder=" Add description" >
                                    <input type="file" name="addsingletrack" id="addsingletrack" class="inputfile" />
                                    <label for="addsingletrack"> Choose a file</label>
                                    <button id="uploadtrack" type="button"> Upload</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <section class="usermusic">
                <button data-music="track" class="addtrack">
                    Add playlist
                </button>
            </section>
            <!-- POPUP ADD PLAYLIST==================================================================================-->
            <div class="popup" id="track">
                <div class="popup-inner">
                    <div class="popup-close">X</div>
                    <div class="headerlist">
                        <h2>Create playlist</h2>
                        <img src="${contextPath}/resources/img/earphones.png">
                    </div>
                    <div class="conteineraddtrack">
                        <div id="headerforaddplaylist" class="row">
                            <div class="col-md-4">
                                <img id="baseimgplaylist" src="${contextPath}/resources/img/owlchat.png">
                                <form id="formimglist">
                                    <input type="file" name="filefoto" id="imgtrack" class="inputfile" />
                                    <label for="imgtrack"> Choose a file</label>
                                    <button id="uploadimgtrack" type="button">Upload</button>
                                </form>
                            </div>
                            <div  class="col-md-8">
                                <%--<form class="settingsprivasy">--%>

                                <%--</form>--%>


                                <form class="settingsprivasy" method="POST" id="formx" action="javascript:void(null);" onsubmit="call()">
                                    <input name="name_playlist" type="text" id="listname" placeholder=" Enter playlist name">
                                    <article>Privasy settings</article>
                                    <label class="checkbox-inline"><input type="radio" name="privacyRadio" value="1" checked>Only I</label>
                                    <label class="checkbox-inline"><input type="radio" name="privacyRadio" value="2">Only My Friends</label>
                                    <label class="checkbox-inline"><input type="radio" name="privacyRadio" value="3">All people</label>
                                    <input name="description_playlist" type="text" id="description" placeholder=" Enter description of playlist">
                                    <input id="createplaylist" value="create" type="submit">
                                </form>



                            </div>
                        </div>
                        <!--====================================================================================================-->
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/mymusic.js"></script>
</body>
</html>
