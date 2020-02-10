var previous = null;
var current = null;
setInterval(function() {
$(document).ready(function() {
    $.ajax({
        url: "https://address-book-web.herokuapp.com/api/viewbook",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET", /* or type:"GET" or type:"PUT" */
        dataType: "json",
        data: {
        },
        success: function (result) {
            console.log(result);
        },
        error: function () {
            console.log("error");
        }
    }).then(function(data) {
        current = JSON.stringify(data);
        if (previous && current && previous !== current) {
            console.log('refresh');
            location.reload();
        }
        else{
            $('.book-id').replaceWith(data.key);
            $('.buddy-count').replaceWith(data.addressBook.length);
        }
        previous = current;
    });
});



}, 2000);