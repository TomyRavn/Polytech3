public class Ex2 {
	//���� ������
	public static void main(String[] args) {
		int x = 20;
		int y = 50;
		int max;
		
		//���ǽ�? True_value:False_value; //���ǽ� �������� ?�� �ݵ�� �����
		//���� �ش��ϴ� ���� ?(QuestionMark) �ٷ� ������, ������ �ش��ϴ� ���� :(Colon) ������ ��ġ
		max = x>y? x:y;	//x>y ���ǽ��� ���̸� x�� ����, �����̸� y�� ����
		System.out.printf("�ִ�:%d\n", max);
	}
}