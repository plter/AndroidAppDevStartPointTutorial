package com.plter.usingstarling
{
	
	import starling.display.Sprite;
	import starling.text.TextField;
	
	public class Game extends Sprite
	{
		public function Game()
		{
			super();
			
			var txt:TextField = new TextField(200,30,"Hello Starling");
			addChild(txt);
		}
	}
}