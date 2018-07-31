var ajaxUrl = "/bookmanager/books/";
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function makeRead(chkbox, id) {
    var readAlready = chkbox.is(":checked");
    $.ajax({
        url: ajaxUrl + id,
        type: "POST",
        data: "readAlready=" + readAlready
    }).done(function () {
        chkbox.closest("tr").attr("book-readAlready", readAlready);
        if(readAlready) {
            successNoty(i18n["read"]);
        }
    }).fail(function () {
        $(chkbox).prop("checked", !readAlready);
    });
}

$(function () {
    datatableApi = $("#bookTable").DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": "",
        },
        "info": true,
        "language": {
            "search": i18n["common.search"]
        },
        "columns": [
            {
                "data": "title",
            },
            {
                "data": "description"
            },
            {
                "data": "author"
            },
            {
                "data": "isbn"
            },
            {
                "data": "printYear"
            },
            {
                "data": "readAlready",
                "render": function (data, type, row) {
                    if (type === "display") {
                        return "<input type='checkbox' " + (data ? "checked" : "") + " onclick='makeRead($(this)," + row.id + ");'/>";
                    }
                    return data;
                }
            },
            {
                "render": renderEditBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderDeleteBtn,
                "defaultContent": "",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "asc"
            ]
        ],
        "createdRow": function (row, data, dataIndex) {
            $(row).attr("book-readAlready", data.readAlready);
        },
        "initComplete": makeEditable
    });
});