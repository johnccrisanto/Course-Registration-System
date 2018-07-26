
$(document).ready(function() {

    $('#username').change(function() {
        $.ajax({
            url: 'validateUsername',
            data:
                {
                    username: $('#username').val()
                },
            success: function(responseText) {
                $('#errorUsername').text(responseText);

                if(responseText !== '') {
                    $('#username').focus();
                }
            }
        });
    });

    $('#email').change(function() {
       $.ajax({

           url: 'validateEmail',
           data: {
              email: $('#email').val()
            },
           success: function(responseText) {

               $('#errorEmail').text(responseText);
               if(responseText !== '') {
                   $('#email').focus();
               }
           }

       });

    });

});