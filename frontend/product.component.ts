import {Component, OnInit} from '@angular/core';
import {Product} from "../shared/product.model";
import {Shop} from "../shared/shop.model";
import {Service} from "../shared/service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{
  products: Product[] = [];
  shops: Shop[] = [];
  productList: Product[] = [];
  name: string = "";
  constructor(private service: Service, public router: Router) { }

  ngOnInit(): void {
    let variable = localStorage.getItem("username");
    if(variable == null){
      this.router.navigate(["login"]);
    }
  }

  getProducts(): void {
    this.service.getProducts().subscribe(p => this.productList = p);
  }

  getProductByName(): void {
    this.service.getProductByName(this.name).subscribe(product => { this.products =  product; });
    console.log(this.products);

  }

  buyProduct(): void {
    this.service.buyProduct(this.name);
  }

  getShops(): void {
    this.service.getShops(this.name).subscribe(s => {  this.shops =  s; });
  }

  logout(): void{
    localStorage.clear();
    this.router.navigate(["login"]);
  }
}
