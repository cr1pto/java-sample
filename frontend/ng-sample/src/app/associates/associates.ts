import { Component, inject, resource, signal } from '@angular/core';
import { HlmTableImports } from '@spartan-ng/helm/table';
import { AssociateItem } from '../models/associate-item';
import { WallmartService } from '../services/wallmart-service';
import { HttpClient, httpResource } from '@angular/common/http';
import { z } from 'zod';

const starWarsPersonSchema = z.object({
  name: z.string(),
  height: z.number(),
  edited: z.string().datetime(),
  films: z.array(z.string()),
});

@Component({
  selector: 'app-associates',
  imports: [HlmTableImports],
  host: {
    class: 'w-full',
  },
  template: `
    <div hlmTableContainer dark>
      <table hlmTable>
        <caption hlmCaption>
          A list of your recent Associates.
        </caption>
        <thead hlmTHead>
          <tr hlmTr>
            <th hlmTh class="w-[100px]">First Name</th>
            <th hlmTh>Last Name</th>
          </tr>
        </thead>
        <tbody hlmTBody>
          @if (allAssociatesResource.hasValue()) {
            @for (associate of allAssociates() ?? []; track $index) {
              <tr hlmTr>
                <td hlmTd class="font-medium">{{ associate.firstName }}</td>
                <td hlmTd>{{ associate.lastName }}</td>
              </tr>
            }
          }
        </tbody>
        <!-- <tfoot hlmTFoot>
					<tr hlmTr>
						<td hlmTd [attr.colSpan]="3">Total</td>
						<td hlmTd class="text-right">$2,500.00</td>
					</tr>
				</tfoot> -->
      </table>
    </div>
  `,
})
export class Associates {
  private apiUrl = 'http://localhost:8080';
  wallmartService = inject(WallmartService);
  // allAssociates = this.wallmartService.getAssociates();
  // allAssociatesResource = httpResource(() => `${this.apiUrl}/associates`); // A reactive function as argument
  allAssociatesResource = httpResource(() => 'http://localhost:8080/associates'); // A reactive function as argument
  allAssociates = signal(
      this.allAssociatesResource.value()
  );
  // id = signal(1);

  // swPersonResource = httpResource(() => `https://swapi.dev/api/people/${this.id()}`, {
  //   parse: starWarsPersonSchema.parse,
  // });

  constructor() {
    console.log(this.allAssociatesResource.hasValue());
    console.log(this.allAssociates);
    this.fetchAssociates();
  }

  fetchAssociates(): AssociateItem[] {
    this.wallmartService.getAssociates().subscribe((res) => {
      console.log('subscribe', res);
      this.allAssociates.update(() => res);
    });
    return [];
  }
  // fetchedAssociates = resource(

  // );
}
