$(document).ready(function () {
    $("#request-form").submit(function (event) {
        event.preventDefault();
        submitRequest();
    });
});

function submitRequest() {
    var data = $("#request-input").val();
    //TODO some js magic and validation before sending it to the server
    //for eg.: do not show the Submit button if the textarea is not filled
    $.ajax({
        type: "POST",
        url: "/ajax-endpoint",
        contentType: "application/json",
        data: data,
        async: false,
        cache: false,
        processData:false,
        success: function (data) {
            var json = "<pre>" + JSON.stringify(data, null, 4) + "</pre>";
            $('#response-div').html(json);
        },
        error: function (e) {
            var json = "<pre>" + e.responseText + "</pre>";
            $('#response-div').html(json);
        }
    });

}