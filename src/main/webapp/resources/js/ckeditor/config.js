/**
 * @license Copyright (c) 2003-2020, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	
	// plugin 추가
	config.extraPlugins = 'uploadimage,wordcount,notification,youtube';
	config.extraPlugins = 'uploadimage,wordcount,notification,youtube,confighelper';
	
	config.toolbarGroups = [
		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
		{ name: 'forms', groups: [ 'forms' ] },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
		{ name: 'links', groups: [ 'links' ] },
		{ name: 'insert', groups: [ 'insert' ] },
		'/',
		{ name: 'styles', groups: [ 'styles' ] },
		{ name: 'colors', groups: [ 'colors' ] },
		{ name: 'tools', groups: [ 'tools' ] },
		{ name: 'others', groups: [ 'others' ] },
		{ name: 'about', groups: [ 'about' ] }
		];

	// Define changes to default configuration here. For example:
	// ckeditor 높이 설정
	config.height = 350
	config.language = 'ko';
	config.uiColor = '#D1E9CA';
	

	// 글자수 세기를 위한 설정
	config.wordcount = {

		    // Whether or not you want to show the Paragraphs Count
		    showParagraphs: true,

		    // Whether or not you want to show the Word Count
		    showWordCount: true,

		    // Whether or not you want to show the Char Count
		    showCharCount: true,

		    // Whether or not you want to count Spaces as Chars
		    countSpacesAsChars: false,

		    // Whether or not to include Html chars in the Char Count
		    countHTML: false,
		    
		    // Maximum allowed Word Count, -1 is default for unlimited
		    maxWordCount: -1,

		    // Maximum allowed Char Count, -1 is default for unlimited
//		    maxCharCount: -1,
		    maxCharCount: 2000,

		    // Add filter to add or remove element before counting (see CKEDITOR.htmlParser.filter), Default value : null (no filter)
		    filter: new CKEDITOR.htmlParser.filter({
		        elements: {
		            div: function( element ) {
		                if(element.attributes.class == 'mediaembed') {
		                    return false;
		                }
		            }
		        }
		    })
		};
	
	// ckeditor youtube video
	// video frame
	config.youtube_width = '640';
	config.youtube_height = '480';
	//video frame 반응형
	config.youtube_responsive = true;
	// 관련 동영상 보기
	config.youtube_related = true;
	config.youtube_older = false;
	config.youtube_privacy = false;
	// 동영상 자동 재생
	config.youtube_autoplay = false;
	// 동영상 컨트롤 qhduwnrl
	config.youtube_controls = true;
	
//	config.youtube_disabled_fields = ['txtEmbed', 'chkAutoplay'];
	

	config.removePlugins = 'easyimage, cloudservices';
	config.removeButtons = 'NewPage,Preview,Print,Templates,SelectAll,Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,CopyFormatting,RemoveFormat,BidiLtr,BidiRtl,Flash,PageBreak,ShowBlocks';
};
