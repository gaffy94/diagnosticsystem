<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>E-Permit </title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <!--AUTO COMPLETE-->
    <link href="${pageContext.request.contextPath}/css/easy-autocomplete.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/easy-autocomplete.themes.min.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/css/custom.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="docalculate"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">

        <div class="animate form login_form">
            <section class="login_content">

                <h1>Diagnostic System</h1>
                <div class="alert alert-danger alert-dismissable bottomspace hide" id="message"
                     value="${message}">${message}</div>
                <div class="form-group">
                    <label for="symptom">Symptom</label>
                    <input type="text" id="symptom" class="form-control symptom" required name="symptom"/>
                </div>
                <div class="form-group">
                    <label for="symptoms">Selected Symptoms</label>
                    <textarea type="text" id="symptoms" class="form-control symptom" readonly name="symptoms">

                        </textarea>
                </div>
                <div class="form-group">
                    <button class="btn btn-default" id="add">Add to Symptoms</button>
                    <button class="btn btn-default" id="clear">Clear Selection</button>
                </div>
                <div class="form-group">
                    <button class="btn btn-default" id="diagnose">Get Diagnosis</button>

                </div>

                <div class="clearfix"></div>

                <div class="separator">


                    <div class="clearfix"></div>
                    <br/>

                    <div>

                    </div>
                </div>


            </section>
        </div>
        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form>
                    <h1>Diagnostic Results</h1>
                    <div id="resultwrapper">


                    </div>


                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">Perform Another Diagnosis?
                            <a href="#signin" class="to_register"> Go Back </a>
                        </p>

                        <div class="clearfix"></div>
                        <br/>

                    </div>
                </form>
            </section>
        </div>

    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!--AUTO COMPLETE-->
<script src="${pageContext.request.contextPath}/js/jquery.easy-autocomplete.min.js"></script>
<!--Page Script-->
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>
