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
                            <form action="${formUrl}" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right"><fmt:message
                                            key="label.guideline.title" bundle="${lang}"/></label>
                                    <div class="col-sm-9">
                                        <input type="text" name="pojo.title" id="title" value="${item.pojo.title}"/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right"><fmt:message
                                            key="label.grammarguideline.upload.image" bundle="${lang}"/></label>
                                    <div class="col-sm-9">
                                        <input type="file" name="file"/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right"><fmt:message
                                            key="label.guideline.content" bundle="${lang}"/></label>
                                    <div class="col-sm-9">
                                        <input type="text" name="pojo.content" id="content" value="${item.pojo.content}"/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="submit" class="btn btn-white btn-warning btn-bold"
                                               value="<fmt:message key="label.done" bundle="${lang}"/>"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <h2>This is a heading</h2>

                <p>This is a paragraph.</p>
                <p>This is another paragraph.</p>

                <button>Click me to hide paragraphs</button>
            </div>
        </div>
        <script>
            $(document).ready(function(){
                hideAllWhenClickButton();
            });
            function hideAllWhenClickButton() {
                $("button").click(function(){
                    $("p").hide();
                });
            }
        </script>
    </body>
</html>

