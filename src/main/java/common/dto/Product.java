package common.dto;

/* 판매상품 테이블을 저장하는 DTO
 * 먹거리 상품을 저장함
 * */
public class Product {
	
	// member field
	// 상품 번호
	private int productNo;
	// 상품 이름
	private String name;
	// 상품 상세 설명
	private String explain;
	// 상품 효능
	private String effect;
	// 상품으로 해먹을 수 있는 요리
	private String food;
	// 상품 종류
	private String kind;
	// 상품 원산지
	private String productCountry;
	// 상품을 판매하는 농업인의 번호
	private int farmerNo;
	// 상품 판매 승인 여부(승인이 되어야 판매 페이지에 보인다)
	private int productSas;
	// 상품 배달방법
	private String delivery;
	// 상품이 제철 음식 여부를 나타내는 컬럼
	private int isSeasonalFood;
	// 판매된 양
	private int sales;

	// getter(), setter()
	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getProductCountry() {
		return productCountry;
	}

	public void setProductCountry(String productCountry) {
		this.productCountry = productCountry;
	}

	public int getFarmerNo() {
		return farmerNo;
	}

	public void setFarmerNo(int farmerNo) {
		this.farmerNo = farmerNo;
	}

	public int getProductSas() {
		return productSas;
	}

	public void setProductSas(int productSas) {
		this.productSas = productSas;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public int getIsSeasonalFood() {
		return isSeasonalFood;
	}

	public void setIsSeasonalFood(int isSeasonalFood) {
		this.isSeasonalFood = isSeasonalFood;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	// toString()
	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", name=" + name + ", explain=" + explain + ", effect=" + effect
				+ ", food=" + food + ", kind=" + kind + ", productCountry=" + productCountry + ", farmerNo=" + farmerNo
				+ ", productSas=" + productSas + ", delivery=" + delivery + ", isSeasonalFood=" + isSeasonalFood
				+ ", sales=" + sales + "]";
	}

}
