/**
 * Format date
 */
$('#date').datepicker({
    clearBtn: true,
    language: /*[[${#strings.concat(#locale.language, '-', #locale.country)}]]*/,
    autoclose: true,
	format: {
        toDisplay: function (date, format, language) {
            var d = date.getDate() + '.' + date.getMonth() + '.' + date.getFullYear();
            return d;
        },
        toValue: function (date, format, language) {
            return new Date(date);
        }
    }
});
