import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../model/customer';
import { Place } from '../model/place';
import { RestService } from '../_service/rest.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor(public service: RestService, public router: Router) { }
  area: Place = new Place();
  days: number = 0;
  totalprice: number = 0;
  user: Customer = new Customer();
  ngOnInit(): void {
    this.user = this.service.getUserdetails();
    this.area = this.service.getplace();
    console.log(this.area)
  }
  total(a: string) {
    this.days = +a
    this.totalprice = (this.days * this.area.price)
  }
  checkout(a: Place) {
    alert(`Thank you for the Confirmation ${this.user.username}`)
    this.service.EmailtoCustomer("manishsharma4901@gmail.com", "BOOKING CONFIRMATION", `${this.user.username} had Confirmed Booking For ${this.area.name} at ${this.area.location} for ${this.days} Days price : ${this.totalprice} contact the customer at ${this.user.phone}`).subscribe(d => console.log(d), f => console.log(f));
    this.router.navigate(['home'])
  }

}
