package sample01_1_ScreenChange;

//コーディング時に画面を簡単に切り替える方法
public class Main {
	static MainWindow mainWindow;
	public static void main(String[] args) {
		mainWindow = new MainWindow(); //ウインドウのみ生成
		mainWindow.preparePanels();    //ペインに直接貼るパネルのみを生成
		mainWindow.prepareComponents();//その他のコンポーネントを生成
		mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);//起動後最初に表示すべき画面を一番前面に持ってきて、そのリスナーをフォーカス
		mainWindow.setVisible(true);   //最後にこれで、ウインドウが出る

	}
}
