
$(".dropdown-toggle").click(function(e) {
    e.preventDefault();
    e.stopPropagation();
    $(this)
        .closest(".search-dropdown")
        .toggleClass("open");
});

$(".dropdown-menu > li > a").click(function(e) {
    e.preventDefault();
    var clicked = $(this);

    clicked
        .closest(".dropdown-menu")
        .find(".menu-active")
        .removeClass("menu-active");
    clicked.parent("li").addClass("menu-active");
    clicked
        .closest(".search-dropdown")
        .find(".toggle-active")
        .html(clicked.html());
    var curr = clicked.outerText;
    console.log(curr);

    if(curr==="Pegawai"){
        document.getElementsByName("input").className = 'search-input';
        $('.search-input').attr("placeholder", "Nomor pegawai (Contoh : 100000000)");
        $('.search-input').attr("name", "nip");
        $('.expanding-search-form').attr("th:action", "@{/pegawai}");
    }
    else if (curr==="Jabatan"){
        document.getElementsByName("input").className = 'dropdown-content';
        $('.dropdown-content').attr("placeholder", "Nama jabatan (Contoh : Kepala Dinas)");
        $('.dropdown-content').attr("name", "idJabatan");
        $('.expanding-search-form').attr("th:action", "@{/jabatan/view}");

    }

});

$(document).click(function() {
    $(".search-dropdown.open").removeClass("open");
});
