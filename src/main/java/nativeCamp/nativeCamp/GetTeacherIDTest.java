package nativeCamp.nativeCamp;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetTeacherIDTest {

    static String responseString = "\t<p id=\"count-result\" class=\"search_result_txt hide\">搜尋到<em>2</em>位講師</p>\n" +
            "\t<ul class=\"user_list_style_2 user_list_style-box\" id=\"list\">\t\t\n" +
            "\t\t <!-- if not studysapuri -->\n" +
            "\t\t<!-- counselor -->\n" +
            "\t\t\t\t\t\t        \t    \n" +
            "\t\t\t\t <!-- endif not studysapuri -->\n" +
            "\n" +
            "\t\t<!-- //Avatar parent Teachers -->\n" +
            "\t\t\t\t<!-- //Avatar parent Teachers -->\n" +
            "\n" +
            "\t    \t    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
            "\t\t\t<li class=\"user_list_item user_list_item--wait\">\n" +
            "\t\t\t\t\t\t\t<div class=\"fav_area\">\n" +
            "\t\t\t\t\t<div class=\"fav_inner_div\">\n" +
            "\t\t\t\t\t\t<div class=\"fav_ttl\">我的收藏</div>\n" +
            "\t\t\t\t\t\t<a href=\"#\" class=\"fav_inner\" data-id=\"43554\">\n" +
            "\t\t\t\t\t\t\t<img data-type=\"1\" class=\"fav_icon off hide\" src=\"/user/images/icon/fav-off.png\" alt=\"我的收藏 off\">\n" +
            "\t\t\t\t\t\t\t<img data-type=\"0\" class=\"fav_icon on \" src=\"/user/images/icon/fav-on.png\" alt=\"我的收藏 on\">\n" +
            "\t\t\t\t\t\t</a>\n" +
            "\t\t\t\t\t\t<div class=\"fav_flash_wrap hide\">\n" +
            "\t\t\t\t\t\t\t<div class=\"fav_flash_inner\" data-listLoadedOnAjax=\"1\">\n" +
            "\t\t\t\t\t\t\t\t<p>以新增至收藏</p>\n" +
            "\t\t\t\t\t\t\t\t<a rel=\"modal\" href=\"javascript:void(0)\" onclick = \"manageNewTeacherFavCategory(43554);\" class=\"t_link\">儲存至清單 &gt;</a>\t\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t<!-- --------------- -->\n" +
            "\t\t\t\t<!-- Normal teacher -->\n" +
            "\t\t\t\t<!-- --------------- -->\n" +
            "\n" +
            "\t\t\t\t<a class=\"user_list_item_inner d_table\" href=\"https://nativecamp.net/zh-tw/waiting/detail/43554\">\n" +
            "\t\t\t\t\t<div class=\"clm_l\">\n" +
            "\t\t\t\t\t\t<div class=\"clm_inner\">\n" +
            "\t\t\t\t\t\t\t\t<figure class=\"thumb\">\n" +
            "\t\t\t\t\t\t\t\t\t<img class=\"pic\" src=\"https://nativecamp-public-web-production.s3-ap-northeast-1.amazonaws.com/2021_05_24_16060360ab505be31d9.png\" alt=\"Nini\">\n" +
            "\t\t\t\t\t\t\t\t</figure>\n" +
            "\t\t\t\t\t\t\t<div class=\"name_area\">\n" +
            "\t\t\t\t\t\t\t\t<p class=\"name\"><span data-id=\"43554\" class=\"teacher_latest_status lesson_status_circle lesson_status_circle--wait\"></span><span class=\"overflow\">Nini</span></p>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<div class=\"clm_r\">\n" +
            "\t\t\t\t\t\t<div class=\"clm_inner\">\n" +
            "\t\t\t\t\t\t\t<div class=\"msg_area\">\n" +
            "\t\t\t\t\t\t\t\t<p>\n" +
            "\t\t\t\t\t\t\t\t\tHi!! My name is Nini and I will become your favourite teacher! I've graduated from physics and mathe...\t\t\t\t\t\t\t\t </p>\n" +
            "\t\t\t\t\t\t\t\t<p class=\"change_language_link t_right\">\n" +
            "\t\t\t\t\t\t\t\t\t<span class=\"t_link js_link\" data-url=\"https://nativecamp.net/zh-tw/waiting/detail/43554?translation=on#teacher_information\">查看翻譯</span>\n" +
            "\t\t\t\t\t\t\t\t</p>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t<div class=\"data_area\">\n" +
            "\t\t\t\t\t\t\t\t<div class=\"ui-rating_area\">\n" +
            "\t\t\t\t\t\t\t\t\t<div class=\"rating_star_wrap v_middle\"><span class=\"rating_star\">\n" +
            "\t\t\t\t\t\t\t\t<span class=\"rating_star_value\" style=\"width:100%;\"></span>\n" +
            "\t\t\t\t\t\t\t</span><span class=\"rating_star\">\n" +
            "\t\t\t\t\t\t\t\t<span class=\"rating_star_value\" style=\"width:100%;\"></span>\n" +
            "\t\t\t\t\t\t\t</span><span class=\"rating_star\">\n" +
            "\t\t\t\t\t\t\t\t<span class=\"rating_star_value\" style=\"width:100%;\"></span>\n" +
            "\t\t\t\t\t\t\t</span><span class=\"rating_star\">\n" +
            "\t\t\t\t\t\t\t\t<span class=\"rating_star_value\" style=\"width:100%;\"></span>\n" +
            "\t\t\t\t\t\t\t</span><span class=\"rating_star\">\n" +
            "\t\t\t\t\t\t\t\t<span class=\"rating_star_value\" style=\"width:93%;\"></span>\n" +
            "\t\t\t\t\t\t\t</span></div><span class=\"rate\" title=\"ユーザー評価\">4.93</span>\t\t\t\t\t\t\t\t\t<span class=\"lesson_count\" title=\"上課數\">(39次)</span>\n" +
            "\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"flag_area\">\n" +
            "\t\t\t\t\t\t\t\t<figure>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img class=\"flag\" src=\"/user/images/flag/georgia.png\" alt=\"Georgia\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<figcaption class=\"flag_name\">Georgia</figcaption>\n" +
            "\t\t\t\t\t\t\t\t</figure>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"status_area\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p class=\"teacher_status avail_kids\">對應兒童</p> \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t</a>\n" +
            "\t\t\t</li>\n" +
            "\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
            "\t\t\t<li class=\"user_list_item user_list_item--wait\">\n" +
            "\t\t\t\t\t\t\t<div class=\"fav_area\">\n" +
            "\t\t\t\t\t<div class=\"fav_inner_div\">\n" +
            "\t\t\t\t\t\t<div class=\"fav_ttl\">我的收藏</div>\n" +
            "\t\t\t\t\t\t<a href=\"#\" class=\"fav_inner\" data-id=\"44486\">\n" +
            "\t\t\t\t\t\t\t<img data-type=\"1\" class=\"fav_icon off hide\" src=\"/user/images/icon/fav-off.png\" alt=\"我的收藏 off\">\n" +
            "\t\t\t\t\t\t\t<img data-type=\"0\" class=\"fav_icon on \" src=\"/user/images/icon/fav-on.png\" alt=\"我的收藏 on\">\n" +
            "\t\t\t\t\t\t</a>\n" +
            "\t\t\t\t\t\t<div class=\"fav_flash_wrap hide\">\n" +
            "\t\t\t\t\t\t\t<div class=\"fav_flash_inner\" data-listLoadedOnAjax=\"1\">\n" +
            "\t\t\t\t\t\t\t\t<p>以新增至收藏</p>\n" +
            "\t\t\t\t\t\t\t\t<a rel=\"modal\" href=\"javascript:void(0)\" onclick = \"manageNewTeacherFavCategory(44486);\" class=\"t_link\">儲存至清單 &gt;</a>\t\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t<!-- --------------- -->\n" +
            "\t\t\t\t<!-- Normal teacher -->\n" +
            "\t\t\t\t<!-- --------------- -->\n" +
            "\n" +
            "\t\t\t\t<a class=\"user_list_item_inner d_table\" href=\"https://nativecamp.net/zh-tw/waiting/detail/44486\">\n" +
            "\t\t\t\t\t<div class=\"clm_l\">\n" +
            "\t\t\t\t\t\t<div class=\"clm_inner\">\n" +
            "\t\t\t\t\t\t\t\t<figure class=\"thumb\">\n" +
            "\t\t\t\t\t\t\t\t\t<img class=\"pic\" src=\"https://nativecamp-public-web-production.s3-ap-northeast-1.amazonaws.com/2021_06_19_17253860cdaa020182f.png\" alt=\"Nina\">\n" +
            "\t\t\t\t\t\t\t\t</figure>\n" +
            "\t\t\t\t\t\t\t<div class=\"name_area\">\n" +
            "\t\t\t\t\t\t\t\t<p class=\"name\"><span data-id=\"44486\" class=\"teacher_latest_status lesson_status_circle lesson_status_circle--wait\"></span><span class=\"overflow\">Nina</span></p>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<div class=\"clm_r\">\n" +
            "\t\t\t\t\t\t<div class=\"clm_inner\">\n" +
            "\t\t\t\t\t\t\t<div class=\"msg_area\">\n" +
            "\t\t\t\t\t\t\t\t<p>\n" +
            "\t\t\t\t\t\t\t\t\tHi there! My name is Nina and I look forward to meeting you and helping you learn the English langua...\t\t\t\t\t\t\t\t </p>\n" +
            "\t\t\t\t\t\t\t\t<p class=\"change_language_link t_right\">\n" +
            "\t\t\t\t\t\t\t\t\t<span class=\"t_link js_link\" data-url=\"https://nativecamp.net/zh-tw/waiting/detail/44486?translation=on#teacher_information\">查看翻譯</span>\n" +
            "\t\t\t\t\t\t\t\t</p>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t<div class=\"data_area\">\n" +
            "\t\t\t\t\t\t\t\t<div class=\"ui-rating_area\">\n" +
            "\t\t\t\t\t\t\t\t\t<div class=\"rating_star_wrap v_middle\"><span class=\"rating_star\">\n" +
            "\t\t\t\t\t\t\t\t<span class=\"rating_star_value\" style=\"width:100%;\"></span>\n" +
            "\t\t\t\t\t\t\t</span><span class=\"rating_star\">\n" +
            "\t\t\t\t\t\t\t\t<span class=\"rating_star_value\" style=\"width:100%;\"></span>\n" +
            "\t\t\t\t\t\t\t</span><span class=\"rating_star\">\n" +
            "\t\t\t\t\t\t\t\t<span class=\"rating_star_value\" style=\"width:100%;\"></span>\n" +
            "\t\t\t\t\t\t\t</span><span class=\"rating_star\">\n" +
            "\t\t\t\t\t\t\t\t<span class=\"rating_star_value\" style=\"width:100%;\"></span>\n" +
            "\t\t\t\t\t\t\t</span><span class=\"rating_star\">\n" +
            "\t\t\t\t\t\t\t\t<span class=\"rating_star_value\" style=\"width:56%;\"></span>\n" +
            "\t\t\t\t\t\t\t</span></div><span class=\"rate\" title=\"ユーザー評価\">4.56</span>\t\t\t\t\t\t\t\t\t<span class=\"lesson_count\" title=\"上課數\">(52次)</span>\n" +
            "\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"flag_area\">\n" +
            "\t\t\t\t\t\t\t\t<figure>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img class=\"flag\" src=\"/user/images/flag/serbia.png\" alt=\"Serbia\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<figcaption class=\"flag_name\">Serbia</figcaption>\n" +
            "\t\t\t\t\t\t\t\t</figure>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"status_area\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t</a>\n" +
            "\t\t\t</li>\n" +
            "\n" +
            "\t\t\t</ul>\n" +
            "<script>\n" +
            "\t/*$('.favorite_div').on('click', function(e){\n" +
            "\t\te.preventDefault();\n" +
            "\t})*/\n" +
            "</script>\n" +
            "<script>\n" +
            "var canLoad = false;\n" +
            "var tempClick = 0;\n" +
            "var teddyCount = \"0\";\n" +
            "var pageCaller = \"mypage\";\n" +
            "$(function() {\n" +
            "\tvar lists = $(\"#list li\");\n" +
            "\tlists.css({opacity: 0});\n" +
            "\tlists.fadeTo(\"slow\", 1);\n" +
            "\t$(\"#seeMoreButton\").on(\"click\", function(){\n" +
            "\t\tif(tempClick>0 && (pageCaller == 'mypage' || pageCaller == 'waiting')) {\n" +
            "\t\t\treturn;\n" +
            "\t\t}\n" +
            "\t\tcanLoad = false;\n" +
            "\t\ttempClick+=1;\n" +
            "\t\t\t$(\"#see-more-limit\").val('');\n" +
            "\t\t\t$(\"#seeMoreButton\").hide();\n" +
            "\t\t\t\n" +
            "\t\t\t$(\"#see-more-count\").val($(\"#list li\").length);\n" +
            "\t\t\t$.ajax({\n" +
            "\t\t\t\ttype: 'POST',\n" +
            "\t\t\t\tdata: getSearchData(),\n" +
            "\t\t\t\turl: '/user/MyPage/getMoreTeacher/mypage',\n" +
            "\t\t\t\tbeforeSend: function() {\n" +
            "\t\t\t\t\tif(pageCaller == 'mypage' || pageCaller == 'waiting') {\n" +
            "\t\t\t\t\t\t$(\".instructor_list_wrap_2\").append('<i class=\"fa fa-spinner fa-spin\" style=\"   display: block;width: 30px;   margin: 0 auto;    font-size: 30px;\"></i>');\t\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\tsuccess: function(res){\n" +
            "\t\t\t\t\tvar result = JSON.parse(res);\n" +
            "\t\t\t\t\t$(\"#list\").append(result.teacher_list);\n" +
            "\t\t\t\t\t$(\"ul.user_list_style_2\").find(\"li.tmp_o\").each(function(i,e){\n" +
            "\t\t\t\t\t\t$(e).css({opacity: 0}).fadeTo(\"slow\", 1).removeClass(\"tmp_o\");\n" +
            "\t\t\t\t\t});\n" +
            "\t\t\t\t\t$(\"#see-more-data\").val(result.limitGauge);\n" +
            "\t\t\t\t\tif (!result.nextPageCount) {\n" +
            "\t\t\t\t\t\t$(\"#showMoreBox\").hide();\n" +
            "\t\t\t\t\t\t$(\"#see-more-default\").val('off');\n" +
            "\t\t\t\t\t} else {\n" +
            "\t\t\t\t\t\t$(\"#see-more-default\").val('on');\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t\t$(\"#see-more-history\").val($(\"#list li\").length);\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\tcomplete: function(){\n" +
            "\t\t\t\t\tif(pageCaller != 'mypage' && pageCaller != 'waiting') {\n" +
            "\t\t\t\t\t\t$(\"#seeMoreButton\").show();\n" +
            "\t\t\t\t\t} else {\n" +
            "\t\t\t\t\t\t$(\".instructor_list_wrap_2 .fa-spinner\").remove();\n" +
            "\t\t\t\t\t\tcanLoad = true;\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "      });  \n" +
            "\t\treturn false;\n" +
            "\t});\n" +
            "\tif ($(\"#see-more-default\").val() == \"off\" ) {\n" +
            "\t\t$(\"#showMoreBox\").hide();\n" +
            "\t}\n" +
            "\t$(window).on('scroll', function() {\n" +
            "\t\tvar totalHeight = $(window).scrollTop() + $(window).height();\n" +
            "\t\t\n" +
            "\t\tif($('#showMoreBox').is(':visible')){\n" +
            "\t\t\tif($(this).scrollTop()>=($('#showMoreBox').position().top - 300) && (pageCaller == 'mypage' || pageCaller == 'waiting') && canLoad && tempClick>0) {\n" +
            "\t\t\t\tcanLoad = false;\n" +
            "\t\t\t\tloadMoreOnScroll();\n" +
            "\t\t\t}\n" +
            "\t\t\tif(totalHeight == $(document).height() && (pageCaller == 'mypage' || pageCaller == 'waiting') && canLoad && tempClick>0) {\n" +
            "\t\t\t\tcanLoad = false;\n" +
            "\t\t\t\tloadMoreOnScroll();\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t})\n" +
            "\t$(document).on(\"click\",\".js_link\",function(e) {\n" +
            "\t\te.stopPropagation();\n" +
            "\t\te.preventDefault();\n" +
            "\t\tvar a = $(this).attr('data-url');\n" +
            "\t\twindow.open(a, '_blank');\n" +
            "\t});\n" +
            "});\n" +
            "function loadMoreOnScroll() {\n" +
            "\t$(\"#see-more-limit\").val('');\n" +
            "\t$(\"#see-more-count\").val($(\"#list li\").length);\n" +
            "\tvar getSearchDataReturn = getSearchData();\n" +
            "\tgetSearchDataReturn.onScrollLimit = 150;\n" +
            "\t$.ajax({\n" +
            "\t\ttype: 'POST',\n" +
            "\t\tdata: getSearchDataReturn,\n" +
            "\t\turl: '/user/MyPage/getMoreTeacher/mypage',\n" +
            "\t\tbeforeSend: function() {\n" +
            "\t\t\t$(\".instructor_list_wrap_2\").append('<i class=\"fa fa-spinner fa-spin\" style=\"   display: block;width: 30px;   margin: 0 auto;    font-size: 30px;\"></i>');\n" +
            "\t\t},\n" +
            "\t\tsuccess: function(res){\n" +
            "\t\t\tvar result = JSON.parse(res);\n" +
            "\t\t\t$(\"#list\").append(result.teacher_list);\n" +
            "\t\t\t$(\"ul.user_list_style_2\").find(\"li.tmp_o\").each(function(i,e){\n" +
            "\t\t\t\t$(e).css({opacity: 0}).fadeTo(\"slow\", 1).removeClass(\"tmp_o\");\n" +
            "\t\t\t});\n" +
            "\t\t\t$(\"#see-more-data\").val(result.limitGauge);\n" +
            "\t\t\tif (!result.nextPageCount) {\n" +
            "\t\t\t\tcanLoad = false;\n" +
            "\t\t\t} else {\n" +
            "\t\t\t\tcanLoad = true;\n" +
            "\t\t\t}\n" +
            "\t\t\t$(\"#see-more-history\").val($(\"#list li\").length);\n" +
            "\t\t},\n" +
            "\t\tcomplete: function(){\n" +
            "\t\t\t$(\".instructor_list_wrap_2 .fa-spinner\").remove();\n" +
            "\t\t}\n" +
            "\t});\n" +
            "}\n" +
            "</script>\n" +
            "\n";




    public static void main(String[] args) {

        getTeacherIDSet();

    }
    public static void getTeacherIDSet(){
        Set<Integer> teacherIDSet = new HashSet();
        String[]array= responseString.split("https://nativecamp.net/zh-tw/waiting/detail/");
        for(int i=1;i< array.length;i+=2){
            String id = array[i].substring(0,5);
            teacherIDSet.add(Integer.parseInt(id));
            System.out.println(id);
        }
    }
}
