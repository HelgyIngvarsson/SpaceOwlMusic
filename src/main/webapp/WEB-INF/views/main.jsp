<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="${contextPath}/resources/css/mainpage.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/popup.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/signupform.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/TopSongs.css">
    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.css">
    <!-- Generic page styles -->
</head>
<body style="padding:0px; margin:0px; background-color:#fff;font-family:'Open Sans',sans-serif,arial,helvetica,verdana">
<!-- #region Jssor Slider Begin -->
<script src="${contextPath}/resources/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/js/jssor.slider-23.1.6.mini.js" type="text/javascript"></script>


<script type="text/javascript">
    jQuery(document).ready(function ($) {

        var jssor_1_SlideoTransitions = [
            [{b: 900, d: 2000, x: -379, e: {x: 7}}],
            [{b: 900, d: 2000, x: -379, e: {x: 7}}],
            [{b: -1, d: 1, o: -1, sX: 2, sY: 2}, {
                b: 0,
                d: 900,
                x: -171,
                y: -341,
                o: 1,
                sX: -2,
                sY: -2,
                e: {x: 3, y: 3, sX: 3, sY: 3}
            }, {b: 900, d: 1600, x: -283, o: -1, e: {x: 16}}]
        ];

        var jssor_1_options = {
            $AutoPlay: 1,
            $SlideDuration: 800,
            $SlideEasing: $Jease$.$OutQuint,
            $CaptionSliderOptions: {
                $Class: $JssorCaptionSlideo$,
                $Transitions: jssor_1_SlideoTransitions
            },
            $ArrowNavigatorOptions: {
                $Class: $JssorArrowNavigator$
            },
            $BulletNavigatorOptions: {
                $Class: $JssorBulletNavigator$
            }
        };

        var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

        /*responsive code begin*/
        /*remove responsive code if you don't want the slider scales while window resizing*/
        function ScaleSlider() {
            var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
            if (refSize) {
                refSize = Math.min(refSize, 1920);
                jssor_1_slider.$ScaleWidth(refSize);
            }
            else {
                window.setTimeout(ScaleSlider, 30);
            }
        }

        ScaleSlider();
        $(window).bind("load", ScaleSlider);
        $(window).bind("resize", ScaleSlider);
        $(window).bind("orientationchange", ScaleSlider);
        /*responsive code end*/
    });
</script>
<style>
    /* jssor slider bullet navigator skin 05 css */
    /*
    .jssorb05 div           (normal)
    .jssorb05 div:hover     (normal mouseover)
    .jssorb05 .av           (active)
    .jssorb05 .av:hover     (active mouseover)
    .jssorb05 .dn           (mousedown)
    */
    .jssorb05 {
        position: absolute;
    }

    .jssorb05 div, .jssorb05 div:hover, .jssorb05 .av {
        position: absolute;
        /* size of bullet elment */
        width: 16px;
        height: 16px;
        background: url('${contextPath}/resources/img/b05.png') no-repeat;
        overflow: hidden;
        cursor: pointer;
    }

    .jssorb05 div {
        background-position: -7px -7px;
    }

    .jssorb05 div:hover, .jssorb05 .av:hover {
        background-position: -37px -7px;
    }

    .jssorb05 .av {
        background-position: -67px -7px;
    }

    .jssorb05 .dn, .jssorb05 .dn:hover {
        background-position: -97px -7px;
    }

    /* jssor slider arrow navigator skin 22 css */
    /*
    .jssora22l                  (normal)
    .jssora22r                  (normal)
    .jssora22l:hover            (normal mouseover)
    .jssora22r:hover            (normal mouseover)
    .jssora22l.jssora22ldn      (mousedown)
    .jssora22r.jssora22rdn      (mousedown)
    .jssora22l.jssora22lds      (disabled)
    .jssora22r.jssora22rds      (disabled)
    */
    .jssora22l, .jssora22r {
        display: block;
        position: absolute;
        /* size of arrow element */
        width: 40px;
        height: 58px;
        cursor: pointer;
        background: url('${contextPath}/resources/img/a22.png') center center no-repeat;
        overflow: hidden;
    }

    .jssora22l {
        background-position: -10px -31px;
    }

    .jssora22r {
        background-position: -70px -31px;
    }

    .jssora22l:hover {
        background-position: -130px -31px;
    }

    .jssora22r:hover {
        background-position: -190px -31px;
    }

    .jssora22l.jssora22ldn {
        background-position: -250px -31px;
    }

    .jssora22r.jssora22rdn {
        background-position: -310px -31px;
    }

    .jssora22l.jssora22lds {
        background-position: -10px -31px;
        opacity: .3;
        pointer-events: none;
    }

    .jssora22r.jssora22rds {
        background-position: -70px -31px;
        opacity: .3;
        pointer-events: none;
    }
</style>

<div class="wrapper">
    <header class="header">
        <div class="container">
            <div class="header_top">
                <div class="header_logo">
                    <div>
                        <a href="#">
                            <img src="${contextPath}/resources/img/logoowl.png">
                        </a>
                    </div>

                    <div class=header_logoname>Space Owl Music</div>
                </div>
                <div class="header_menu">
                    <ul class="menu">
                        <li class="menu_item">
                            <a href="#" class="menu_link_iconed">
                                <span class="menu_link-icon"> <img src="${contextPath}/resources/img/search.png"></span>
                                <span class="menu_link-text"> Search</span>
                            </a>
                        </li>
                        <li class="menu_item">
                            <a href="#" class="menu_link"">
                            <span class="menu_link-text"> Home</span>
                            </a>
                        </li>
                        <li class="menu_item">
                            <a href="TopSongs.html" class="menu_link">
                                <span class="menu_link-text"> Top Songs</span>
                            </a>
                        </li>
                        <li class="menu_item">
                            <a href="#" class="menu_link"">
                            <span class="menu_link-text"> About us</span>
                            </a>
                        </li>
                        <li class="menu_item">
                            <a href="#" class="menu_link"">
                            <span class="menu_link-text"> People </span>
                            </a>
                        </li>
                        <li class="menu_item">
                            <button id="signlogin">
                                <span class="menu_link-text"> Sign in/Sign up</span>
                            </button>
                        </li>

    </header>
</div>
<!--
-->
<div class="mainslider">
    <div id="jssor_1"
         style="position:relative;margin:0 auto;top:0px;left:0px;width:1300px;height:500px;overflow:hidden;visibility:hidden;">
        <!-- Loading Screen -->
        <div data-u="loading" style="position:absolute;top:0px;left:0px;background-color:rgba(0,0,0,0.7);">
            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
            <div style="position:absolute;display:block;background:url('${contextPath}/resources/img/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
        </div>
        <div data-u="slides"
             style="cursor:default;position:relative;top:0px;left:0px;width:1300px;height:500px;overflow:hidden;">
            <div>
                <img data-u="image" src="${contextPath}/resources/img/blue.jpg"/>

                <div style=" position:absolute;top:30px;left:30px;width:480px;height:120px;z-index:0;font-size:20px;color:#ffffff;line-height:60px;">
                    <div style="text-align:start; position:absolute;top:300px;left:30px;width:480px;height:120px;z-index:0;font-size:25px;color:black;line-height:1.45; ">
                        <span style="background:rgb(255, 255, 255)" ;>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem ea commodi, rem dicta </span>
                        <button class="slider_button">Listen to music now</button>
                    </div>
                </div>

            </div>
            <div>
                <img data-u="image" src="${contextPath}/resources/img/purple.jpg"/>
            </div>
            <div>
                <img data-u="image" src="${contextPath}/resources/img/red.jpg"/>
            </div>
        </div>
        <!-- Bullet Navigator -->
        <div data-u="navigator" class="jssorb05" style="bottom:16px;right:16px;" data-autocenter="1">
            <!-- bullet navigator item prototype -->
            <div data-u="prototype" style="width:16px;height:16px;"></div>
        </div>
        <!-- Arrow Navigator -->
        <span data-u="arrowleft" class="jssora22l" style="top:0px;left:8px;width:40px;height:58px;"
              data-autocenter="2"></span>
        <span data-u="arrowright" class="jssora22r" style="top:0px;right:8px;width:40px;height:58px;"
              data-autocenter="2"></span>
    </div>
    <!-- <div class="popup"> -->
    <!-- <div class="popup-inner">
    <div class="popup-close">X</div>
    <form>
    <section class="formelem">
    <label>Login(Username)</label>
    <input type="text" placeholder="Enter Username" name="uname" required>
    </section>
    <section class="formelem">
    <label>Password</label>
    <input type="Password" placeholder="Enter Password" name="psw" required>
    </section>
    <button class="login" type="submit">Login</button>
    </form>
    </div>
    </div>
    <div class
    </div> -->
    <div class="popup">
        <div class="popup-inner">
            <div class="popup-close">X</div>
            <!-- ФОРМА============================================== -->
            <div class="form">

                <ul class="tab-group">
                    <li class="tab active"><a href="#signup">Sign Up</a></li>
                    <li class="tab"><a href="#login">Log In</a></li>
                </ul>

                <div class="tab-content">
                    <div id="signup">
                        <h1>Sign Up for Free</h1>

                        <form:form method="POST" modelAttribute="userForm" action="${contextPath}/registration" class="form-signin">

                            <div class="top-row">
                                <div class="field-wrap">
                                    <form:input name="firstname" type="text" path="firstName" class="form-control"
                                                placeholder="Your first name"></form:input>
                                </div>

                                <div class="field-wrap">
                                    <form:input name="lastName" type="text" path="lastName" class="form-control"
                                                placeholder="Your last name "></form:input>
                                </div>
                            </div>

                            <div class="field-wrap">
                                <form:input name="email" type="text" path="email" class="form-control"
                                            placeholder="Your email "></form:input></div>
                            <div class="field-wrap">
                                <form:input name="username" type="text" path="username" class="form-control"
                                            placeholder="Your username"></form:input>
                            </div>
                            <div class="field-wrap">
                                <form:input name="password" type="text" path="password" class="form-control"
                                            placeholder="Your password"></form:input>
                            </div>
                            <div class="field-wrap">

                                <form:input name="password" type="text" path="confirmPassword" class="form-control"
                                            placeholder="Your confirmPassword"></form:input></div>

                            <button id="submitsignup" type="submit" class="button button-block"/>
                            Get Started</button>

                        </form:form>

                    </div>


                    <div id="login">
                        <h1>Welcome Back!</h1>

                        <form method="POST" action="${contextPath}/login" class="form-signin">
                            <div class="field-wrap">
                                <input placeholder="login" name="username" type="text" required autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <input placeholder="Your password" name="password" type="password" required autocomplete="off"/>
                            </div>

                            <p class="forgot"><a href="#">Forgot Password?</a></p>

                            <button class="button button-block"/>
                            Log In</button>

                        </form>

                    </div>

                </div><!-- tab-content -->

            </div> <!-- /form -->


            <!--========== КОНЕЦ ФОРМЫ============================= -->
        </div>
    </div>
    <div class
    <section class="wrapper">
        <section class="musicpart">
            <h2>Top Songs</h2>
            <img src="${contextPath}/resources/img/audio/Iconmusuc.png">
        </section>
        <section id="audio">
            <section>
                <a style="display:block;" href=#>Track 1</a>
                <img class="scrinimg" src="${contextPath}/resources/img/audio/audiotrack1.png">
                <a href=#> <img src="${contextPath}/resources/img/audio/heart.png">Like</a>
            </section>
            <section>
                <a style="display:block;" href=#>Track 1</a>
                <img class="scrinimg" src="${contextPath}/resources/img/audio/audiotrack6.png">
                <a href=#> <img class="likes" src="${contextPath}/resources/img/audio/heart.png">Like</a>
            </section>

            <section>
                <a href"=#">Track 1</a>
                <img class="scrinimg" src="${contextPath}/resources/img/audio/audiotrack2.png">
                <a href=#> <img class="likes" src="${contextPath}/resources/img/audio/heart.png">Like</a>
            </section>
            <section>
                <a style="display:block;" href=#>Track 1</a>
                <img class="scrinimg" src="${contextPath}/resources/img/audio/audiotrack3.png">
                <a href=#> <img class="likes" src="${contextPath}/resources/img/audio/heart.png">Like</a>
            </section>
            <section>
                <a style="display:block;" href=#>Track 1</a>
                <img class="scrinimg" src="${contextPath}/resources/img/audio/audiotrack4.png">
                <a href=#> <img class="likes" src="${contextPath}/resources/img/audio/heart.png">Like</a>
            </section>
            <section>
                <a style="display:block;" href=#>Track 1</a>
                <img class="scrinimg" src="${contextPath}/resources/img/audio/audiotrack7.png">
                <a href=#> <img class="likes" src="${contextPath}/resources/img/audio/heart.png">Like</a>
            </section>
            <section>
                <a style="display:block;" href=#>Track 1</a>
                <img class="scrinimg" src="${contextPath}/resources/img/audio/audiotrack8.jpeg">
                <a href=#> <img class="likes" src="${contextPath}/resources/img/audio/heart.png">Like</a>
            </section>
            <section>
                <a style="display:block;" href=#>Track 1</a>
                <img class="scrinimg" src="${contextPath}/resources/img/audio/audiotrack9.jpeg">
                <a href=#> <img class="likes" src="${contextPath}/resources/img/audio/heart.png">Like</a>
            </section>
            <section>
                <a style="display:block;" href=#>Track 1</a>
                <img class="scrinimg" src="${contextPath}/resources/img/audio/audiotrack10.jpeg">
                <a href=#> <img class="likes" src="${contextPath}/resources/img/audio/heart.png">Like</a>
            </section>
        </section>
        <div class="linkshowmore">
            <a href="#">Show more</a>
        </div>
    </section>
    </section>


    <script type="text/javascript" src="${contextPath}/resources/js/popup.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/audiopart(track).js"></script>
    <script src="${contextPath}/resources/js/signform.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
