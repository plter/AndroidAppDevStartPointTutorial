package
{
	import com.plter.usingstarling.Game;
	
	import flash.display.Sprite;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	
	import starling.core.Starling;
	
	public class Main extends Sprite
	{
		
		
		private var starling:Starling;
		
		
		public function Main()
		{
			super();
			
			stage.align = StageAlign.TOP_LEFT;
			stage.scaleMode = StageScaleMode.NO_SCALE;
			stage.autoOrients=false;
			
			starling = new Starling(Game,stage);
			starling.start();
		}
	}
}