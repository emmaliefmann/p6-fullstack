import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@Component({
    selector: 'app-root',
    imports: [RouterOutlet, BrowserAnimationsModule],
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    standalone: true
})
export class AppComponent {
  title = 'front';
}
