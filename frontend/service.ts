import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from "./product.model";
import {Shop} from "./shop.model";

@Injectable()
export class Service {

  private apiBaseURL = 'http://localhost:9099';
  private urlProduct = 'http://localhost:9090';
  private urlShop = 'http://localhost:9092';
  constructor(private httpClient: HttpClient) {
  }

  getProductByName(name: string ): Observable<Array<Product>>{
    console.log(name);
    console.log(`${this.urlProduct}/prod/${name}`);
    return this.httpClient
      .get<Array<Product>>(`${this.urlProduct}/prod/${name}`);
  }


  getProducts(): Observable<Array<Product>>{
    console.log(`${this.urlProduct}/prods`);
    return this.httpClient
      .get<Array<Product>>(`${this.urlProduct}/prods`);
  }

  buyProduct(name: string ): void {
    console.log(`${this.urlProduct}/buy`);
      this.httpClient
        .post(`${this.urlProduct}/buy/${name}`,name).subscribe();
    }

  getShops(product: string ): Observable<Array<Shop>>{
    console.log(product);
    console.log(`${this.urlShop}/shop/${product}`);
    return this.httpClient
      .get<Array<Shop>>(`${this.urlShop}/shop/${product}`);
  }
}
