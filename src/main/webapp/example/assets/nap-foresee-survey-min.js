var NapForeseeSurvey=(function(){var l=false;var f;var b;var a;var j="en";function e(m){this.isBlocked=m}function k(){d();g()}function d(){f=CookieUtil.getCookie("channel");a=CookieUtil.getCookie("lang_iso");b=CookieUtil.getCookie("country_iso")}function g(){if(h()!==j){l=true}}function c(){return f}function i(){return b}function h(){if(a){return a}else{return j}}k();return{isBlocked:l,setBlockSurvey:e,getRegion:c,getCountry:i,getLanguage:h}}());if(typeof module!=="undefined"){module.exports=NapForeseeSurvey};