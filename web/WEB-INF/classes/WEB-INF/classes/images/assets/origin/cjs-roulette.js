define(["view/cjs","model/cjs-loader","model/data","model/manifest-loader","util/local-storage","view/common/workaround"],function(a,b,c,d,e,f){var g=12,h="cjs_exportRoot_",i=a.extend({rouletteParam:null,initialize:function(a){if(this.attr=a,"start"===a.status){var b=this,d=a.isSpecialmode===!0?"special_mode_start":"start";this.gachaRouletteModel=new(c.extend({urlRoot:Game.baseUri+"gacha/roulette/"+d})),this.listenToOnce(this.gachaRouletteModel,"sync",function(a){b.rouletteParam=a.get("param"),b.render()}),this.gachaRouletteModel.fetch()}else this.render()},render:function(){var a=this,c=[this.attr.cjsName];b.once("complete",function(){function e(a,b,c){var d=_.clone(a);return _.some(d,function(a){return a.id===b?(a.src=c,!0):void 0}),d}var i=_.flatten(_.map(c,function(a){return b.manifest(a)}));if(_.isNull(a.rouletteParam)===!1){var j=a.rouletteParam.roulette_result,k=a.rouletteParam.roulette_skin_id,l=a.attr.cjsName,m=Game.imgUri+"/sp/cjs/",n=[{id:l+"_roulette_in_dummy",src:m+l+"_roulette_in_"+k+".png"},{id:l+"_roulette_in_roll_dummy",src:m+l+"_roulette_in_roll_"+k+".png"},{id:l+"_free_text_dummy",src:m+l+"_free_text_"+j+".png"}];_.each(n,function(a){i=e(i,a.id,a.src)})}d.once("complete",function(){createjs.MotionGuidePlugin.install();var b=new createjs.Container,c=new lib[a.attr.cjsName];if(_.isNull(a.rouletteParam)===!1){a.trigger("rouletteNext",a.rouletteParam.url);var d=a.rouletteParam;window[h+a.attr.cjsName]=c,window.msgArray=d.msgArray,window.roulette_result=d.roulette_result,window.final_max_gacha=!!d.final_max_gacha,window.is_all_unlimited_gacha=!!d.is_all_unlimited_gacha,window.special_gacha_point=d.special_gacha_point,window.roulette_angle=+d.roulette_angle}b.addChild(c);var e=document.getElementById(a.attr.cjsId);if(window.CreateJsShell&&1==Game.setting.cjs_mode&&e.setAttribute("cjs-context","shell"),a.stage=new createjs.Stage(e),window.CreateJsShell&&1==Game.setting.cjs_mode){var i=e.getAttribute("dena-context");if("shell"==i){var j=function(){for(var a=e.parentElement;a;a=a.parentElement)a.style.backgroundColor="transparent"};createjs.patch_delay_run_for_android4_0_x(j),Game.ua.isAndroid()&&"4.2.2"===Game.ua.os.version&&f.webkitGlobalRepaint()}}a.stage.addChild(b),a.stage.update(),createjs.Ticker.setFPS(g,!0),createjs.Ticker.addEventListener("tick",a.stage)}),d.loadManifest(i,!0)}),b.loadFiles(c)},removeChildren:function(){this.stage.removeAllEventListeners("tick"),this.stage.removeAllChildren(),this.stage.clear(),this.stage=null},destroy:function(){_.isNull(this.rouletteParam)===!1&&(delete window[h+this.attr.cjsName],delete window.msgArray,delete window.roulette_result,delete window.final_max_gacha,delete window.is_all_unlimited_gacha,delete window.special_gacha_point,delete window.roulette_angle)}});return i});