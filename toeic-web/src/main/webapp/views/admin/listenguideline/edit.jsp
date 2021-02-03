<%--
  Created by IntelliJ IDEA.
  User: nguyenlinhphuong
  Date: 1/11/21
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/admin-guideline-listen-list.html"/>

<html>
    <head>
        <title><fmt:message key="label.guideline.listen.edit" bundle="${lang}"/></title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs" id="breadcrumbs">
                    <script type="text/javascript">
                        try {
                            ace.settings.check('breadcrumbs', 'fixed')
                        } catch (e) {
                        }
                    </script>

                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#"><fmt:message key="label.home" bundle="${lang}"/></a>
                        </li>
                        <li class="active"><fmt:message key="label.guideline.listen.list" bundle="${lang}"/></li>
                    </ul><!-- /.breadcrumb -->
                </div>
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <a href="${listenGuidelineEditUrl}" type="button">Them bai HD</a>
                            <c:if test="${not empty messageResponse}">
                                <div class="alert alert-block alert-${alert}">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <i class="ace-icon fa fa-times"></i>
                                    </button>
                                        ${messageResponse}
                                </div>
                            </c:if>
                            <%--<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"></label>
                                <div class="col-sm-9">
                                    <h2>This is a heading</h2>

                                    <p>This is a paragraph.</p>
                                    <p>This is another paragraph.</p>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"></label>
                                <div class="col-sm-9">
                                    <button>Click me to hide paragraphs</button>
                                </div>
                            </div>--%>
                            <%--    .html()-.val()  Methods                      --%>
                            <%--<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"></label>
                                <div class="col-sm-9">
                                    <input type="text" value="JSP-SERVLET myclass.vn" id="value"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"></label>
                                <div class="col-sm-9">
                                    <p id="showValue">Nothing in this</p>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"></label>
                                <div class="col-sm-9">
                                    <button onclick="usingValAction()">Show Info</button>
                                </div>
                            </div>--%>
                            <%--       .prop()-.attr() Methods                    --%>
                            <%--<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"></label>
                                <div class="col-sm-9">
                                    <input type="checkbox"  id="testCheckbox" checked/>
                                </div>
                            </div>--%>
                            <%--        .css()   Method                 --%>
                            <%--<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"></label>
                                <div class="col-sm-9">
                                    <p style="color: red" id="demoCssMethod1">Test css method</p>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"></label>
                                <div class="col-sm-9">
                                    <button id="demoCssMethod" onclick="demoCssMethod()">Change Color</button>
                                </div>
                            </div>--%>
                            <%--Jquery change() method--%>
                            <%--<input type="checkbox" id="sex" onchange="changeValueCheckbox()"/>--%>
                            <input type="checkbox" id="sex"/>
                            <p id="textSex"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                hideAllWhenClickButton();
                changeValueCheckbox();
            });

            function hideAllWhenClickButton() {
                $("button").click(function () {
                    $("p").hide();
                });
            }

            function usingValAction() {
                var value = $('#value').val();
                $('#showValue').html(value);
            }

            function demoCssMethod() {

                $('#demoCssMethod1').css("color", "blue");

            }

            function changeValueCheckbox() {
                /*if ($('#sex').prop('checked') == true) {
                    $('#textSex').html('<h1>Male</h1>');
                } else {
                    $('#textSex').html('<h1>Female</h1>');
                }*/
                $('#sex').on('change', function () {
                    if ($('#sex').prop('checked') == true) {
                        $('#textSex').html('<h1>Male</h1>');
                    } else {
                        $('#textSex').html('<h1>Female</h1>');
                    }
                });
            }
        </script>
    </body>
</html>

