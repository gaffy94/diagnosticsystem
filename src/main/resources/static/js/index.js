$(document).ready(function (){
    var symptoms = {};
    var selectedsymptoms = [];
    var temps;
    var selectedids = []
    $.ajax({
        type: "GET",
        url: "/symptoms",
        async: false,
        success: function (resp) {
          console.log(resp);
          symptoms  = resp;
        },
        error: function (xhr, status, text) {
            // alert(text);

        }
    });
    if($('#message').text() != ""){
        console.log("in here");
        $('#message').removeClass('hide');
    }
    var options = {
        data: symptoms,
        getValue: "symptom",
        list: {
            match: {
                enabled: true
            },
            onChooseEvent: function() {
                var index = $("#symptom").getSelectedItemData().id;
                temps = index;
            }
        }
    };
    $("#symptom").easyAutocomplete(options);

    $('#add').on('click',function(e){
        e.preventDefault();
        selectedsymptoms.push($('#symptom').val());
        selectedids.push(temps);
        $('#symptoms').val("");
        $('#symptoms').val(selectedsymptoms.toString());
        $('#symptom').val("");
    });

    $('#clear').on('click', function(e){
        e.preventDefault();
        $('#symptoms').val("");
        selectedsymptoms = [];
        selectedids = [];
    });


    $('#diagnose').on('click', function(e){
        e.preventDefault();
        console.log(selectedids);
        $.ajax({
            type: "POST",
            url: "/dodiagnosis",
            data: JSON.stringify(selectedids),
            async: false,
            dataType : "json",
            contentType: "application/json; charset=utf-8",
            success: function (resp) {
                console.log(resp);
                $('#resultwrapper').empty();
                if(resp.length > 0){
                    $.each( resp, function( i, val ) {
                        $('#resultwrapper').append("<div>\n" +
                            "                            <p class=\"text-left text-capitalize\"><b>Disease:"+ val.disease+"</b></p>\n" +
                            "                            <p class=\"text-left text-capitalize\"><b>Confidence Level: "+val.confidencePercent+"%</b></p>\n" +
                            "                            <div class=\"progress\">\n" +
                            "                                <div class=\"progress-bar progress-bar-info\" data-transitiongoal=\""+val.confidencePercent+"\"\n" +
                            "                                     aria-valuenow=\""+val.confidencePercent+"\" style=\"width: "+val.confidencePercent+"%;\"></div>\n" +
                            "                            </div>\n" +
                            "                        </div>");
                    });
                } else {
              $('#resultwrapper').append("  <div class=\"alert alert-info alert-dismissible fade in\" role=\"alert\">\n" +
                  "                        <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span>\n" +
                  "                    </button>\n" +
                  "                    <strong>Holy guacamole!</strong> No Diagnosis available for you.. Enter more descriptive symptoms for better results.\n" +
                  "                    </div>");
                }

                $(location).attr('href', '#docalculate');
            },
            error: function (xhr, status, text) {
                // alert(text);

            }
        });
    });
});