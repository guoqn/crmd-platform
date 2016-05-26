/**
 * 右侧快速操作
 * kongge@office.weiphone.com
 * 2012.06.07
*/
jQuery(function($){
	//创建DOM
	var 
	quickHTML = '<div class="quick_links_panel"><div id="quick_links" class="quick_links"><a href="#top" class="return_top"><i class="topb"></i><span>返回顶部</span></a><a href="#" class="leave_message"><i class="qa"></i><span>意见建议</span></a></div><div class="quick_toggle"><a href="javascript:;" class="toggle" title="展开/收起">×</a></div></div><div id="quick_links_pop" class="quick_links_pop hide"></div>',
	quickShell = $(document.createElement('div')).html(quickHTML).addClass('quick_links_wrap'),
	quickLinks = quickShell.find('.quick_links');
	quickPanel = quickLinks.parent();
	quickShell.appendTo('body');
	
	//具体数据操作 
	var 
	quickPopXHR,
	loadingTmpl = '<div class="loading" style="padding:30px 80px"><i></i><span>Loading...</span></div>',
	popTmpl = '<div class="title"><h3><i></i><%=title%></h3></div><div class="pop_panel"><form><%=content%></form></div><div class="arrow"><i></i></div><div class="fix_bg"></div>',
	historyListTmpl = '<ul><%for(var i=0,len=items.length; i<5&&i<len; i++){%><li><a href="<%=items[i].productUrl%>" target="_blank" class="pic"><img alt="<%=items[i].productName%>" src="<%=items[i].productImage%>" width="60" height="60"/></a><a href="<%=items[i].productUrl%>" title="<%=items[i].productName%>" target="_blank" class="tit"><%=items[i].productName%></a><div class="price" title="单价"><em>&yen;<%=items[i].productPrice%></em></div></li><%}%></ul>',
	newMsgTmpl = '<ul><li><a href=""><span class="tips">新回复<em class="num"><b><%=items.commentNewReply%></b></em></span>商品评价/晒单</a></li><li><a href=""><span class="tips">新回复<em class="num"><b><%=items.consultNewReply%></b></em></span>商品咨询</a></li><li><a href=""><span class="tips">新回复<em class="num"><b><%=items.messageNewReply%></b></em></span>我的留言</a></li><li><a href="'+'"><span class="tips">新通知<em class="num"><b><%=items.arrivalNewNotice%></b></em></span>到货通知</a></li><li><a href=""><span class="tips">新通知<em class="num"><b><%=items.reduceNewNotice%></b></em></span>降价提醒</a></li></ul>',
	quickPop = quickShell.find('#quick_links_pop'),
	quickDataFns = {
		//快速导航
		my_qlinks: {
			title: '快速导航',
			content: '<div class="links"><ul><li><a href="">订单信息</a></li><li><a href="">账务信息</a></li><li><a href="">收费信息</a></li><li><a href="">客户信息</a></li><li><a href="">故障单信息</a></li></ul></div>',
			init: $.noop
		},
		
		
		//给客服留言
		leave_message: {
			title: '意见建议',
			content: '<div class="types"><input type="radio" name="type" id="type_1" value="10" checked /><label for="type_1">系统易用性</label><input type="radio" name="type" id="type_3" value="20" /><label for="type_3">界面美观</label><input type="radio" name="type" id="type_4" value="99"/><label for="type_4">其他</label></div><div class="txt"><textarea name="msg" id="msg" cols="30" rows="10" placeholder="请输入您的宝贵意见..."></textarea></div><div class="token"></div><div class="btns"><button type="submit" style="border:1px solid #3789cc;background:#3f9eeb;padding:3px 20px;color:white;"><span>提交</span></button></div>',
			init: function(ops){
				setTimeout(function(){
					quickPop.find('textarea').focus();
				}, 100);
				//验证码
				//quickPop.find('#token_txt').bind('focus', getValidateCode);
				
				//效验 & 提交数据
				var form = quickPop.find('form');
				//form.attr("action",saveMessageUrl);
				form.bind('submit', function(e){
					e.preventDefault();
					var data = form.serialize();
					if(!checkMessageForm()){
						return false;
					}
					var type=quickPop.find(':radio:checked').val();
					jQuery.ajax({
						type:'post',
						url: saveMessageUrl, 
						data:{"message_style":type,"message_content":$("#msg").val(),"checkcode":$("#token_txt").val()},
						dataType:"json",
						error:function(value){
							ds.dialog.alert('留言失败');
						},
						success: function(value){
//							var success = value.success;
//							var info = value.info;
//							if(success==1){
//								hideQuickPop();
//								showInfoTip(info, 'success');
//							}else{
//								ds.dialog.alert(info);
//							}

							var success = value.result;
							var info = value.object;
							if(success){
								hideQuickPop();
								showInfoTip(info, 'success');
							}else{
								ds.dialog.alert(info);
							}
						}
					});
				});
			}
		}
	};
	
	//showQuickPop
	var 
	prevPopType,
	prevTrigger,
	doc = $(document),
	popDisplayed = false,
	hideQuickPop = function(){
		if(prevTrigger){
			prevTrigger.removeClass('current');
		}
		popDisplayed = false;
		prevPopType = '';
		quickPop.hide();
	},
	showQuickPop = function(type){
		if(quickPopXHR && quickPopXHR.abort){
			quickPopXHR.abort();
		}
		if(type !== prevPopType){
			var fn = quickDataFns[type];
			quickPop.html(ds.tmpl(popTmpl, fn));
			fn.init.call(this, fn);
		}
		doc.unbind('click.quick_links').one('click.quick_links', hideQuickPop);

		quickPop[0].className = 'quick_links_pop quick_' + type;
		popDisplayed = true;
		prevPopType = type;
		quickPop.show();
	};
	quickShell.bind('click.quick_links', function(e){
		e.stopPropagation();
	});

	//通用事件处理
	var 
	view = $(window),
	quickLinkCollapsed = !!ds.getCookie('ql_collapse'),
	getHandlerType = function(className){
		return className.replace(/current/g, '').replace(/\s+/, '');
	},
	showPopFn = function(){
		var type = getHandlerType(this.className);
		if(popDisplayed && type === prevPopType){
			return hideQuickPop();
		}
		showQuickPop(this.className);
		if(prevTrigger){
			prevTrigger.removeClass('current');
		}
		prevTrigger = $(this).addClass('current');
	},
	quickHandlers = {
		//购物车，最近浏览，商品咨询
		my_qlinks: showPopFn,
		message_list: showPopFn,
		history_list: showPopFn,
		leave_message: showPopFn,
		//返回顶部
		return_top: function(){
			ds.scrollTo(0, 0);
			hideReturnTop();
		},
		toggle: function(){
			quickLinkCollapsed = !quickLinkCollapsed;
			
			quickShell[quickLinkCollapsed ? 'addClass' : 'removeClass']('quick_links_min');
			ds.setCookie('ql_collapse', quickLinkCollapsed ? '1' : '', 30);
		}
	};
	quickShell.delegate('a', 'click', function(e){
		var type = getHandlerType(this.className);
		if(type && quickHandlers[type]){
			quickHandlers[type].call(this);
			e.preventDefault();
		}
	});
	
	//Return top
	var scrollTimer, resizeTimer, minWidth = 1350;

	function resizeHandler(){
		clearTimeout(scrollTimer);
		scrollTimer = setTimeout(checkScroll, 160);
	}
	function checkResize(){
		quickShell[view.width() > 1340 ? 'removeClass' : 'addClass']('quick_links_dockright');
	}
	function scrollHandler(){
		clearTimeout(resizeTimer);
		resizeTimer = setTimeout(checkResize, 160);
	}
	function checkScroll(){
		view.scrollTop()>100 ? showReturnTop() : hideReturnTop();
	}
	function showReturnTop(){
		quickPanel.addClass('quick_links_allow_gotop');
	}
	function hideReturnTop(){
		quickPanel.removeClass('quick_links_allow_gotop');
	}

	view.bind('scroll.go_top', resizeHandler).bind('resize.quick_links', scrollHandler);
	quickLinkCollapsed && quickShell.addClass('quick_links_min');
	resizeHandler();
	scrollHandler();
	

	//校验商品咨询表单
	function  checkMessageForm(){
		var content = $("#msg");
		if(content.val()==""){
			ds.dialog({
				   title : '消息',
				   content : "请填写咨询内容！",
				   onyes : function(){
						this.close();
				   },
				   width : 200,
				   lock : true
			});
			return false;
		}

		var checkcode = $("#token_txt").val();
		if(checkcode=="" || checkcode=="点击获取"){
			ds.dialog({
				   title : '消息',
				   content : "验证码不能为空，请输入验证码！",
				   onyes : function(){
						this.close();
				   },
				   width : 200,
				   lock : true
			});
			return false;
		}
		return true;
	}

	//获取验证码
	function getValidateCode(){
		this.value="";
		var validateCodeUrl = validateCode_url+'?t='+Math.random();
		$("#code_img").html('<img id="validate_code_img_id_1" src="' + validateCodeUrl + '" height="20" width="80" alt="验证码" />');
		return;
	}
});

//首次加载站内消息总数
jQuery(function($){
	var shell = $('#quick_links a.message_list');
	if(shell.find("em").length){
		
		$.ajax({
			url: unreadNewMsgUrl,
			dataType: 'json',
			cache: false,
			success: function(data){
				if(1 == data.success){
					if(0 == data.msgtotal){
						shell.find('em').remove();
					}else{
						var num = data.msgtotal;
						//消息总数最大只显示 99
						shell.append('<em class="num"><b>'+ Math.min(99, num) +'</b></em>').show();
					}
				}
			}
		});
	}
});

var _baseUrl = '';
var baseJSUrl = 'right-suspension-menu/js/';
var baseCSSUrl = 'right-suspension-menu/css/';
var account_url="";
var refreshCartUrl="";//购物车
var recentlyViewedUrl=""; //最近浏览
var saveMessageUrl=contextPath+ffc.context.reqSugUrl;//提交留言
var checkout_Url="";//去购物车并结算
var go_buy="";//购买
var place_url="skin/default/img/place.png";//loading图片
var validateCode_url="";//获取验证码
var delCart_url="";
var account_order_url="";
var account_return_url="";
var account_address_url="";
var account_giftcard_url="";
var account_cashcard_url="";
var account_jf_url="";
var account_comment_url = "#";
var account_consult_url = "#";
var account_message_url = "#";
var account_arrival_url = "";
var account_reduce_url = "";
var unreadNewMsgUrl = "";
//Dialog icon base path
ds.Dialog.defaults.iconBasePath = 'right-suspension-menu/img/';
function showInfoTip(content, type, onhide){
	var icons = {success:'success.png', info: 'info.png'};
	var icon = icons[type] || 'error.png';
	return ds.dialog({
		title: '消息提示',
		content: content,
		onhide: onhide,
		onyes: true,
		icon: icon,
		timeout: 3,
		width: 200
	});
}