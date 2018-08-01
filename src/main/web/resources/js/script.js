$(document).ready(function() {

    var UIController = (function() {

        return {
            addListOfCourses: function(listOfCoursesJsonFormat) {
                console.log(listOfCoursesJsonFormat);
                var coursesHtml = '<table class="table table-striped table-hover table-condensed table-bordered table-responsive">' +
                    '<thead><tr><th>Name</th>' +
                    '<th>Description</th>' +
                    '<th>Instructor Name</th>' +
                    '<th>Start Date</th>' +
                    '<th>End Date</th>' +
                    '<th>Enrollment Limit</th>' +
                    '<th>Number Enrolled</th>' +
                    '<th>Register</th>' +
                    '<th>Unregister</th>' +
                    '</thead><tbody>';

                $.each(listOfCoursesJsonFormat, function (index, obj) {

                    coursesHtml = coursesHtml +
                        '<tr><td>' + obj.name + '</td>' +
                        '<td>' + obj.description + '</td>' +
                        '<td>' + obj.instructorName + '</td>' +
                        '<td>' + obj.startDate.month + ' ' + obj.startDate.dayOfMonth + ', ' + obj.startDate.year + '</td>' +
                        '<td>' + obj.endDate.month + ' ' + obj.endDate.dayOfMonth + ', ' + obj.endDate.year + '</td>' +
                        '<td>' + obj.enrollmentLimit + '</td>' +
                        '<td>' + obj.numberEnrolled + '</td>' +
                        '<td>' + '<button id="' + obj.id + '" class="register btn btn-info">Register</button>' + '</td>' +
                        '<td>' + '<button id="' + obj.id + '" class="unregister btn btn-info">Unregister</button>' + '</td>' +
                        '</tr>';
                });
                coursesHtml = coursesHtml + '</tbody></table>';
                document.querySelector('.course_data').innerHTML = coursesHtml;
            }
        }

    })();

    var globalController = (function(UICtrl) {

        var setupEventListeners = function() {

            // New User Registration Form Event Handlers

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

            // Home Page Event Handlers

            $('#coursesImg').click(function() {

                $.ajax({
                    type: 'GET',
                    dataType: 'json',
                    url: 'api/courses',
                    success: function(listOfCoursesJsonFormat) {
                        UICtrl.addListOfCourses(listOfCoursesJsonFormat);
                    },

                });

            });

            document.querySelector('.course_data').addEventListener('click', regOrUnreg);

            // Utility Methods

        }

        var regOrUnreg = function(event) {

            var value = event.target.innerHTML;
            var targetId = event.target.id;

            if(value === 'Register') {
                $.ajax({

                    url: 'register/registerForCourse',
                    data: {
                        id: targetId,
                    },

                    success: function(responseText) {
                        // Display the status of the registration to the user
                        document.querySelector('.registrationMessage').innerHTML = '<span class="alert alert-info">' + responseText + '</span>';
                        document.querySelector('')
                    },

                    error: function() {

                    }
                });
            } else if (value === 'Unregister') {
                $.ajax( {

                    url: 'register/unregisterFromCourse',
                    data: {
                        id: targetId,
                    },
                    success: function(responseText) {
                        // Display the status of the registration to the user
                        document.querySelector('.registrationMessage').innerHTML = '<span class="alert alert-info">' + responseText + '</span>';
                    },

                    error: function() {

                    }
                });
            }
        }

        return {
            init: function() {
                setupEventListeners();
            }
        }

    })(UIController);

    globalController.init();

});