import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MessagesComponent} from './messages/components/messages/messages.component';

@Component({
  selector: 'devops-root',
  imports: [RouterOutlet, MessagesComponent],
  standalone: true,
  template: `
    <devops-messages/>
    <router-outlet/>
  `
})
export class AppComponent {
}
