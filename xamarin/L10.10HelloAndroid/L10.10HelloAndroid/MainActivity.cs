using System;

using Android.App;
using Android.Content;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.OS;

namespace L10.HelloAndroid
{
	[Activity (Label = "L10.10HelloAndroid", MainLauncher = true)]
	public class Activity1 : Activity
	{
		int count = 1;

		protected override void OnCreate (Bundle bundle)
		{
			base.OnCreate (bundle);

			// Set our view from the "main" layout resource
			SetContentView (Resource.Layout.Main);

			// Get our button from the layout resource,
			// and attach an event to it
			Button button = FindViewById<Button> (Resource.Id.myButton);
			
			button.Click += delegate {
				button.Text = string.Format ("{0} clicks!", count++);
			};

			Button btnShowToast = FindViewById <Button>(Resource.Id.btnShowToast);
			btnShowToast.Click += delegate {
				Toast.MakeText (this, "Hello C#", ToastLength.Short).Show ();

				Console.WriteLine("Button Clicked");
			};
		}
	}
}


