import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerComponent } from './customer.component';

const routes: Routes = [
    { 
        path: '', 
        component: CustomerComponent,        
        children: [
            { path: '', loadChildren: './product/product.module#ProductModule' },
            { path: 'hang/:id', loadChildren: './product/product.module#ProductModule' },
            { path: 'san-pham/:id', loadChildren: './product-detail/product-detail.module#ProductDetailModule' },
            { path: 'gio-hang', loadChildren: './shopping-cart/shopping-cart.module#ShoppingCartModule' },
            { path: 'tim-kiem/:sp', loadChildren: './product/product.module#ProductModule' }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class CustomerRoutingModule {}