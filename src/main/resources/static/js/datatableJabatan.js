$(document).ready( function () {
    var table = $('#tabelJabatan').DataTable({
        "sAjaxSource": "/listjabatan",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "nama", "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                    $(nTd).html("<a href='view?idJabatan=" +oData.id + "'>"+oData.nama+"</a>");
                }},
            { "mData": "deskripsi" },
            { "mData": "gajiPokok"}
        ]
    })
});