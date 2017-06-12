"use strict";

window.app = {};

window.app.addedStudents = [];

window.app.addStudent = function (student,addOption) {
    var span = $('<span class="label label-default">' + student.name + '&nbsp;(' + student.group + ')' + '<span class="remove glyphicon glyphicon-remove-sign glyphicon-white"></span></span>');
    span.click(function () {
        window.app.removeStudent(student);
        span.remove();
    });
    window.app.container.append(span);
    window.app.addedStudents.push(student);
    if (addOption === false) {
        return;
    }
    var option = $('<option selected></option>');
    option.val(JSON.stringify(student));
    option.attr("data-id", student.id);
    window.app.studentsList.append(option);
};

window.app.removeStudent = function (student) {
    //window.app.addedStudents[student.id] = undefined;
    var id = window.app.addedStudents.indexOf(student);
    delete window.app.addedStudents[id];
    window.app.studentsList.children("option[value='" + JSON.stringify(student) + "']").remove();
};

window.app.containStudent = function (student) {
    for (var i = 0; i < window.app.addedStudents.length; i++) {
        if (typeof window.app.addedStudents[i] === 'undefined') {
            continue;
        }
        if (window.app.addedStudents[i].name == student.name && window.app.addedStudents[i].group == student.group) {
            return true;
        }
    }
    return false;
};

window.app.createStudent = function(id, name, group){
    return { id: id, name: name, group: group };
};

window.app.loadStudents = function (selectElement) {
    var options = $(selectElement).children("option[selected]");
    for (var i = 0; i < options.length; i++) {
        var student = JSON.parse($(options[i]).val());
        if (typeof student.id == 'undefined' || typeof student.name == 'undefined' || typeof student.group == 'undefined') {
            continue;
        }
        window.app.addStudent(student, false);
    }
};

(function(app){
    $(function ($) {
        var form = $("form[data-autocomlete-url]")[0];
        app.url = $(form).attr("data-autocomlete-url");
        app.minimalLength = $(form).attr("data-autocomlete-minimal-length");
        app.maxValues = $(form).attr("data-autocomlete-max-values");
        app.container = $("#selected-students-visual");
        app.studentsList = $("#selected-students");
        app.studentName = $("#student");
        app.studentGroup = $("#group");
        app.selectedStudents = $("#students");
        var inputId = $(form).attr("data-autocomlete-input-id");
        var input = $("#" + inputId);
        app.loadStudents(app.studentsList);
        $(input).autocomplete(
        {
            minLength: app.minimalLength,
            source: function (request, response) {
                app.selected = undefined;
                $.ajax({
                    method: "POST",
                    url: app.url,
                    data: {
                        value: request.term,
                        max: app.maxValues,
                    },
                    success: function (data) {
                        for (var i = 0; i < data.length; i++) {
                            data[i].label = data[i].name + ' (' + data[i].group + ')';
                        }
                        response(data);
                    },
                    error: function (result, textStatus, errorThrown) {
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            },
            select: function (event, ui) {
                app.selected = ui.item;
                app.studentName.val(ui.item.name);
                app.studentGroup.val(ui.item.group);
                return false;
            }
        });
        $("#add-student").click(function (e) {
            var currentStudent = app.selected;
            var realGroup = app.studentGroup.val();
            if (typeof app.selected == 'undefined' || app.selected.group != realGroup) {
                currentStudent = app.createStudent(0, app.studentName.val(), realGroup);
                if (currentStudent.name == "" || currentStudent.group == "") {
                    return;
                }
            }
            if (app.containStudent(currentStudent)) {
                return;
            }
            app.studentName.val("");
            app.studentGroup.val("");
            app.addStudent(currentStudent);
            app.selected = undefined;
        });
    });
})(window.app);