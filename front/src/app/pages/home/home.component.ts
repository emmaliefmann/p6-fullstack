import { Component, OnInit, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Topic } from 'src/app/models/topic.model';
import { TopicService } from 'src/app/services/topic.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  constructor(private topicService: TopicService) {}

  public topics!: Topic[];
  
  ngOnInit(): void {
    
  }


}
