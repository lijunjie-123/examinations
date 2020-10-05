var flashvars = {
	f : '', // 视频地址f:'rtmp://192.168.9.163:1935/oflaDemo/1166e3955a794f7d899a938fbfe6f337.flv',
	a : '',// 调用时的参数，只有当s>0的时候有效
	s : '0',// 调用方式，0=普通方法（f=视频地址），1=网址形式,2=xml形式，3=swf形式(s>0时f=网址，配合a来完成对地址的组装)
	c : '0',// 是否读取文本配置,0不是，1是
	x : '',// 调用配置文件路径，只有在c=1时使用。默认为空调用的是ckplayer.xml
	// i:'http://www.ckplayer.com/images/loadimg3.jpg',//初始图片地址
	// d:'http://www.ckplayer.com/down/pause6.1_1.swf|http://www.ckplayer.com/down/pause6.1_2.swf',//暂停时播放的广告，swf/图片,多个用竖线隔开，图片要加链接地址，没有的时候留空就行
	// u:'',//暂停时如果是图片的话，加个链接地址
	// l:'http://www.ckplayer.com/down/adv6.1_1.swf|http://www.ckplayer.com/down/adv6.1_2.swf',//前置广告，swf/图片/视频，多个用竖线隔开，图片和视频要加链接地址
	r : '',// 前置广告的链接地址，多个用竖线隔开，没有的留空
	// t:'10|10',//视频开始前播放swf/图片时的时间，多个用竖线隔开
	y : '',// 这里是使用网址形式调用广告地址时使用，前提是要设置l的值为空
	z : '',// 缓冲广告，只能放一个，swf格式
	e : '2',// 视频结束后的动作，0是调用js函数，1是循环播放，2是暂停播放并且不调用广告，3是调用视频推荐列表的插件，4是清除视频流并调用js功能和1差不多，5是暂停播放并且调用暂停广告
	v : '80',// 默认音量，0-100之间
	p : '1',// 视频默认0是暂停，1是播放，2是不加载视频
	h : '3',// 播放http视频流时采用何种拖动方法，=0不使用任意拖动，=1是使用按关键帧，=2是按时间点，=3是自动判断按什么(如果视频格式是.mp4就按关键帧，.flv就按关键时间)，=4也是自动判断(只要包含字符mp4就按mp4来，只要包含字符flv就按flv来)
	q : '',// 视频流拖动时参考函数，默认是start
	m : '',// 让该参数为一个链接地址时，单击播放器将跳转到该地址
	o : '',// 当m=1时，可以设置视频的时间，单位，秒
	w : '',// 当m=1时，可以设置视频的总字节数
	g : '',// 视频直接g秒开始播放
	j : '',// 跳过片尾功能，j>0则从播放多少时间后跳到结束，<0则总总时间-该值的绝对值时跳到结束
	// k:'30|60',//提示点时间，如 30|60鼠标经过进度栏30秒，60秒会提示n指定的相应的文字
	n : '',// 提示点文字，跟k配合使用，如 提示点1|提示点2
	wh : '',// 宽高比，可以自己定义视频的宽高或宽高比如：wh:'4:3',或wh:'1080:720'
	lv : '0',// 是否是直播流，=1则锁定进度栏
	loaded : 'loadedHandler',// 当播放器加载完成后发送该js函数loaded
	// 调用播放器的所有参数列表结束
	// 以下为自定义的播放器参数用来在插件里引用的
	my_url : encodeURIComponent(window.location.href)
// 本页面地址
// 调用自定义播放器参数结束
};

var params = {
	bgcolor : '#FFF',
	allowFullScreen : false,
	allowScriptAccess : 'always',
	wmode : 'transparent'
};
var ckplayer_id = "ckplayer_index2"; //播放器ID
var postionset = 1; //播放进度控制时间
var lock = true;  //内部锁
var record = null; //播放进度记录回调函数
function initVideoPlayer(_container, _url) {
	
	//_url="rtmp://127.0.0.1:1935/oflaDemo/111111111.flv";
	
	if (_container == null || _container == "" || _container == undefined) {
		return;
	}
	if (_url == null || _url == "" || _url == undefined) {
		return;
	}
	flashvars.f = _url;
	var containerObj = document.getElementById(_container);
	if (containerObj) {
		var _divWidth = containerObj.offsetWidth;
		var _divHeigth = containerObj.offsetHeight;
		CKobject.embedSWF('Js/videoPlayer/ckplayer/ckplayer.swf', _container,
				ckplayer_id, _divWidth, _divHeigth, flashvars, params);
	}
}

function loadedHandler() {
	lock = false;
	CKobject.getObjectById(ckplayer_id).addListener('play', 'playCallBack');
}

function playCallBack() {
	if (!lock) {
		lock = true;
		CKobject.getObjectById(ckplayer_id).videoSeek(0);
	}
}

function control_pause(){
	CKobject.getObjectById(ckplayer_id).videoPause();
}
function control_pause(){
	CKobject.getObjectById(ckplayer_id).videoPause();
}
function control_stop(){
	CKobject.getObjectById(ckplayer_id).videoPause();
	CKobject.getObjectById(ckplayer_id).videoClear();
}

